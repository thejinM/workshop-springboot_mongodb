package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Usuario;
import com.dto.UsuarioDTO;
import com.repository.RepositorioUsuario;
import com.services.exception.ExceptionObjetoNaoEcontrado;

@Service
public class ServicoUsuario 
{
  @Autowired
  private RepositorioUsuario repositorioUsuario;

  public List<Usuario> findAll()
  {
    return repositorioUsuario.findAll();
  }

  public Usuario findById(String id)
  {
    {
        return repositorioUsuario.findById(id).orElseThrow(() -> new ExceptionObjetoNaoEcontrado("Objeto não encontrado!"));
    }
  }

  public Usuario inserir (Usuario obj)
  {
    return repositorioUsuario.insert(obj);  
  }

  public void deletar(String id)
  {
    findById(id);
    repositorioUsuario.deleteById(id);
  }

  public Usuario deUsuario(UsuarioDTO objDTO)
  {
    return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
  }
}