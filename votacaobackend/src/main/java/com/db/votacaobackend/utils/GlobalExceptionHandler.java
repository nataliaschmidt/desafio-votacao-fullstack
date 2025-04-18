package com.db.votacaobackend.utils;

import com.db.votacaobackend.agenda.exception.AgendaBadRequestException;
import com.db.votacaobackend.agenda.exception.AgendaNotFoundExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AgendaBadRequestException.class)
  private ResponseEntity<ErrorMessage> agendaBadRequest(AgendaBadRequestException exception) {
    ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }

  @ExceptionHandler(AgendaNotFoundExcepcion.class)
  private ResponseEntity<ErrorMessage> agendaNotFound(AgendaNotFoundExcepcion exception) {
    ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }


}
