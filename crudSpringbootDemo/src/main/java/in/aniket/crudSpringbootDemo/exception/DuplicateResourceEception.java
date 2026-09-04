package in.aniket.crudSpringbootDemo.exception;

public class DuplicateResourceEception extends RuntimeException {
    public DuplicateResourceEception(String message){
        super(message);
    }


}
