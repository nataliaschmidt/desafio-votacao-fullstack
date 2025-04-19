package com.db.votacaobackend.utils;

import com.db.votacaobackend.agenda.exception.AgendaBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AgendaBadRequestException.class)
  private ResponseEntity<ErrorMessage> agendaNotFound(AgendaBadRequestException exception) {
    ErrorMessage errorMessa = new ErrorMessage(exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessa);
  }

}
