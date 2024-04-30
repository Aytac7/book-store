package az.spring.bookstore.exception;

public class LibraryAlreadyExistsException extends RuntimeException {

    public LibraryAlreadyExistsException(String message, String code) {
        super(message);
    }
}
