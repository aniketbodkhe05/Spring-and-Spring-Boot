package in.aniket.crudSpringbootDemo.exception;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
