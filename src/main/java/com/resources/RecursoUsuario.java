package com.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @PostMapping
  public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDTO)
  {
    Usuario obj = servicoUsuario.deUsuario(objDTO);
    obj = servicoUsuario.inserir(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletar(@PathVariable String id)
  {
    servicoUsuario.deletar(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> atualizar(@RequestBody UsuarioDTO objDTO, @PathVariable String id)
  {
    Usuario obj = servicoUsuario.deUsuario(objDTO);
    obj.setId(id);
    obj = servicoUsuario.atualizar(obj);
    return ResponseEntity.noContent().build();
  }
}