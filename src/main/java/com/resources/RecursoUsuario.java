package com.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Usuario;
import com.dto.UsuarioDTO;
import com.services.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario 
{
  @Autowired
  private ServicoUsuario servicoUsuario;

  @GetMapping
  public ResponseEntity<List<UsuarioDTO>> findAll()
  {
    List<Usuario> lista = servicoUsuario.findAll();
    List<UsuarioDTO> listaDTO = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listaDTO);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UsuarioDTO> findById(@PathVariable String id)
  {
    Usuario obj = servicoUsuario.findById(id);
    return ResponseEntity.ok().body(new UsuarioDTO(obj));
  }
}