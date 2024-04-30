package az.spring.bookstore.exception.handler;

import az.spring.bookstore.exception.*;
import az.spring.bookstore.exception.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class CustomerException  {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handlerUserNotFoundException(Exception exception){
        log.info("handlerUserNotFoundException {}",exception.getMessage());
        return ProblemDetail.forStatusAndDetail(NOT_FOUND,exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerMethodArgumentNotValidException(Exception exception){
        log.info("handlerMethodArgumentNotValidException {}", exception.getMessage());
       return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }


//    @ExceptionHandler(UserNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ProblemDetail handlerUserNotFoundException(UserNotFoundException exception) {
//    log.error("handlerUserNotFoundException {}", exception.getMessage());
//    return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
//}



    @ExceptionHandler(UserSameNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerUserSameNameException(Exception exception){
        log.info("handlerUserNotFoundException {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(PasswordInvalid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerPasswordInvalid(Exception exception){
        log.info("handlerPasswordInvalid {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(UserNameInvalid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerUserNameInvalid(Exception exception){
        log.info("User registration failed due to validation error: {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerIdNotFoundException (Exception exception){
        log.info("Id not found: {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handlerBookNotFoundException (Exception exception){
        log.info("Book not found: {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(LibraryAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerLibraryAlreadyExistsException(Exception exception){
        log.info("Library already exists: {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }
    @ExceptionHandler(BookAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerBookAlreadyExistsException(Exception exception){
        log.info("Book already exists: {}", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerUnauthorizedAccessException(Exception exception){
        log.info("UnauthorizedAccessException", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerLibraryNotFoundException(Exception exception){
        log.info("LibraryNotFoundException", exception.getMessage());
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }
}
