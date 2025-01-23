package com.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.domain.Post;
import com.resources.util.URL;
import com.services.ServicoPost;

@RestController
@RequestMapping(value = "/posts")
public class RecursoPost
{
  @Autowired
  private ServicoPost servicoPost;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id)
  {
    Post obj = servicoPost.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @GetMapping(value = "/buscartitulo")
  public ResponseEntity<List<Post>> buscarTitulo(@RequestParam(value = "texto", defaultValue = "") String texto)
  {
    texto = URL.decodeParameters(texto);
    List<Post> lista = servicoPost.buscarTitulo(texto);
    return ResponseEntity.ok().body(lista);
  }
}