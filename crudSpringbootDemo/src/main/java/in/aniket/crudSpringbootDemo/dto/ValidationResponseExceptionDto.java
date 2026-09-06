package in.aniket.crudSpringbootDemo.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationResponseExceptionDto {
    private LocalDateTime timestamp;
    private  int statuscode;
    private String error;
    private String message;
    private String path;
    private Map<String,String> fielderrors;

    public ValidationResponseExceptionDto(LocalDateTime timestamp, int statuscode, String error, String message, String path, Map<String, String> fielderrors) {
        this.timestamp = timestamp;
        this.statuscode = statuscode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fielderrors = fielderrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFielderrors() {
        return fielderrors;
    }

    public void setFielderrors(Map<String, String> fielderrors) {
        this.fielderrors = fielderrors;
    }
}
