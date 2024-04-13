package az.spring.bookstore.exception.handler;

import az.spring.bookstore.exception.*;
import az.spring.bookstore.exception.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
}
