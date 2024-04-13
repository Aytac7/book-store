package az.spring.bookstore.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String code,String message){
        super(message);
    }
}
