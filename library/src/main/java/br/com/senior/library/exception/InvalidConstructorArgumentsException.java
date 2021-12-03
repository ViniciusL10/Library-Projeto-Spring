package br.com.senior.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PARTIAL_CONTENT, reason = "Parâmetros não informados")
public class InvalidConstructorArgumentsException extends RuntimeException {
    public InvalidConstructorArgumentsException(String msg) {
        super(msg);
    }
}
