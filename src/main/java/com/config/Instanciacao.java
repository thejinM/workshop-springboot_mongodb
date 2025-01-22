package com.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.domain.Post;
import com.domain.Usuario;
import com.dto.AutorDTO;
import com.repository.RepositorioPost;
import com.repository.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner
{
  @Autowired
  private RepositorioUsuario repositorioUsuario;

  @Autowired
  private RepositorioPost repositorioPost;

  @Override
  public void run(String... args) throws Exception 
  {
    repositorioUsuario.deleteAll();
    repositorioPost.deleteAll();

    Usuario barbara = new Usuario(null, "Bárbara Bueno Leidemer", "barbara.leidemer@gmail.com");
    Usuario jean = new Usuario(null, "Jean Michel Mallmann", "jean.mallmann@gmail.com");
    Usuario laudelina = new Usuario(null, "Laudelina da Cruz Bueno", "laudelina.bueno@gmail.com");
    Usuario maegle = new Usuario(null, "Maegle Celisa Bueno Leidemer", "maegle.leidemer@gmail.com");
    Usuario ester = new Usuario(null, "Ester Bueno Leidemer", "ester.leidemer@gmail.com");
    Usuario luiz = new Usuario(null, "Luiz Felipe da Silva Gemeli", "luis.gemeli@gmail.com");
    Usuario sergio = new Usuario(null, "Sérgio Luís Mallmann", "sergio.mallmann@gmail.com");
    Usuario angela = new Usuario(null, "Ângela Rejani Schuck Mallmann", "angela.mallmann@gmail.com");

    repositorioUsuario.saveAll(Arrays.asList(barbara, jean, laudelina, maegle, ester, luiz, sergio, angela));

    Post p1 = new Post(null, Instant.parse("2025-01-21T17:00:00Z"), "imagem.jpg - <3", "Como eu amo a Bárbara!!!", new AutorDTO(jean));

    repositorioPost.saveAll(Arrays.asList(p1));

    jean.getPosts().addAll(Arrays.asList(p1));
    repositorioUsuario.save(jean);
  } 
}