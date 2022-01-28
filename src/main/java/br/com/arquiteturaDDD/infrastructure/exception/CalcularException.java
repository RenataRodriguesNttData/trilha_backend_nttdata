package br.com.arquiteturaDDD.infrastructure.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;

@ControllerAdvice
public class CalcularException {

    @ExceptionHandler(NotFoundException.class)
    public String errorPage() {
        return "error";
    }

}
