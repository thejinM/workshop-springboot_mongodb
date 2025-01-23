package com.resources.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.services.exception.ExceptionObjetoNaoEcontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManipuladorRecurso 
{
  @ExceptionHandler(ExceptionObjetoNaoEcontrado.class)
  public ResponseEntity<ExceptionErroPadrao> objetoNaoEncontrado(ExceptionObjetoNaoEcontrado e, HttpServletRequest request)
  {
    String erro = "Objeto não encontrado!";
    HttpStatus status = HttpStatus.NOT_FOUND;
    ExceptionErroPadrao erroPadrao = new ExceptionErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(erroPadrao);
  }
}