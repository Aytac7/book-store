package az.spring.bookstore.exception;

public class UserSameNameException extends RuntimeException {
    public UserSameNameException(String code, String message){
        super(message);
    }
}
