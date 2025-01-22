package com.dto;

import java.io.Serializable;
import java.time.Instant;

public class ComentarioDTO implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  private String texto;
  private Instant data;
  private AutorDTO autor;

  public ComentarioDTO () {}

  public ComentarioDTO(String texto, Instant data, AutorDTO autor) 
  {
    this.texto = texto;
    this.data = data;
    this.autor = autor;
  }

  public String getTexto() 
  {
    return texto;
  }

  public void setTexto(String texto) 
  {
    this.texto = texto;
  }

  public Instant getData() 
  {
    return data;
  }

  public void setData(Instant data) 
  {
    this.data = data;
  }

  public AutorDTO getAutor() 
  {
    return autor;
  }

  public void setAutor(AutorDTO autor) 
  {
    this.autor = autor;
  }
}