package br.com.senior.library;

import br.com.senior.library.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidTokenException.class, InvalidIdException.class, IdNullException.class, InvalidConstructorArgumentsException.class, InvalidParametersException.class })
    public ResponseEntity<String> handleException(Exception exception, WebRequest request) {
        String msg = exception.getMessage();
        HttpStatus status;
        if (exception instanceof  InvalidTokenException)
            status = HttpStatus.BAD_REQUEST;
        else if ( exception instanceof InvalidIdException)
            status = HttpStatus.NOT_FOUND;
        else if (exception instanceof IdNullException)
            status = HttpStatus.BAD_REQUEST;
        else if(exception instanceof InvalidConstructorArgumentsException)
            status = HttpStatus.PARTIAL_CONTENT;
        else
            status = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<String>("Error: " + msg, status);
    }

}
