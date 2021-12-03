package br.com.senior.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Id não informado")
public class IdNullException extends  RuntimeException {
    public IdNullException(String msg) {
        super(msg);
    }
}
