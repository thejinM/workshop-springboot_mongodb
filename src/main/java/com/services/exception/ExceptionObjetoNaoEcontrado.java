package com.services.exception;

public class ExceptionObjetoNaoEcontrado extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public ExceptionObjetoNaoEcontrado(String msg)
  {
    super(msg);
  }
}