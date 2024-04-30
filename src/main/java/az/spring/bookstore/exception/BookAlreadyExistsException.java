package az.spring.bookstore.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message, String code){
        super(message);
    }
}
