package az.spring.bookstore.exception;

public class UserNameInvalid extends RuntimeException{
    public UserNameInvalid(String code,String message){
        super(message);
    }
}
