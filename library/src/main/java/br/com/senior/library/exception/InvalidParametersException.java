package br.com.senior.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Parâmetros inválidos")
public class InvalidParametersException extends RuntimeException {
    public InvalidParametersException(String msg){
        super(msg);
    }
}
