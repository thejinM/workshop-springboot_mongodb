package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Post;
import com.repository.RepositorioPost;
import com.services.exception.ExceptionObjetoNaoEcontrado;

@Service
public class ServicoPost 
{
  @Autowired
  private RepositorioPost repositorioPost;

  public Post findById(String id)
  {
    {
        return repositorioPost.findById(id).orElseThrow(() -> new ExceptionObjetoNaoEcontrado("Objeto não encontrado!"));
    }
  }

  public List<Post> buscarTitulo(String texto)
  {
    return repositorioPost.findByTitle(texto);
  }
}