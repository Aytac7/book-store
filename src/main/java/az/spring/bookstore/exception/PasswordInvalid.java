package az.spring.bookstore.exception;

public class PasswordInvalid extends RuntimeException{
    public PasswordInvalid(String code,String message){
        super(message);
    }
}
