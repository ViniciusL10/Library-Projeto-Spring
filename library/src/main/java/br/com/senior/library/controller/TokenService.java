package br.com.senior.library.controller;

import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    boolean verify(String token);

}
