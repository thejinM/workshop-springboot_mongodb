package com.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.domain.Post;
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
}