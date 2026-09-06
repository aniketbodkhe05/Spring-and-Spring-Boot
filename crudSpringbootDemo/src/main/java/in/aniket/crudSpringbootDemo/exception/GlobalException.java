package in.aniket.crudSpringbootDemo.exception;

import in.aniket.crudSpringbootDemo.dto.ExceptionResponseDto;
import in.aniket.crudSpringbootDemo.dto.ValidationResponseExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex, HttpServletRequest request){
       ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
               request.getRequestURI()


       );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception ex,HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()


        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);
    }
    @ExceptionHandler(DuplicateResourceEception.class)
    public ResponseEntity<ExceptionResponseDto> handleDuplicateResourceException(DuplicateResourceEception ex,HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()


        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponseExceptionDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpServletRequest request){

        Map<String,String> fieldErrors=new HashMap<>();
       ex.getBindingResult()
               .getFieldErrors()
               .forEach(error ->
                       fieldErrors.put(error.getField(),error.getDefaultMessage()));
        ValidationResponseExceptionDto exceptionResponseDto=new ValidationResponseExceptionDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation failed",
                request.getRequestURI(),
                fieldErrors
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponseDto);
    }
}
