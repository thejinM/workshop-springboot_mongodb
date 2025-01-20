package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Usuario;
import com.repository.RepositorioUsuario;

@Service
public class ServicoUsuario 
{
  @Autowired
  private RepositorioUsuario repositorioUsuario;

  public List<Usuario> findAll()
  {
    return repositorioUsuario.findAll();
  }
}