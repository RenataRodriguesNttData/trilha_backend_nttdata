package br.com.arquiteturaDDD.infrastructure.exception;


import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntryException {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handlerException(CalcularException ex){

        ErrorMessage message = new ErrorMessage("Error");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }


}
