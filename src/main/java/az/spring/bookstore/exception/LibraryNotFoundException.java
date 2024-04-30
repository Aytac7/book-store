package az.spring.bookstore.exception;

public class LibraryNotFoundException extends RuntimeException{
    public LibraryNotFoundException(String message){
        super(message);
    }
}
