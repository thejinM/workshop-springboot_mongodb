package com.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario 
{
  @GetMapping
  public List<Usuario> findAll()
  {
    Usuario barbara = new Usuario("2", "Bárbara Bueno Leidemer", "barbara.leidemer@gmail.com");
    List<Usuario> lista = new ArrayList<>();
    lista.addAll(Arrays.asList(barbara));
    return lista;
  }
}
