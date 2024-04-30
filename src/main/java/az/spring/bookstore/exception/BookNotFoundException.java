package az.spring.bookstore.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message, String code) {
        super(message);
    }
}
