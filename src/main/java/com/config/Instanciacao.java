package com.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.domain.Usuario;
import com.repository.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner
{
  @Autowired
  private RepositorioUsuario repositorioUsuario;

  @Override
  public void run(String... args) throws Exception 
  {
    repositorioUsuario.deleteAll();

    Usuario barbara = new Usuario(null, "Bárbara Bueno Leidemer", "barbara.leidemer@gmail.com");
    Usuario jean = new Usuario(null, "Jean Michel Mallmann", "jean.mallmann@gmail.com");
    Usuario laudelina = new Usuario(null, "Laudelina da Cruz Bueno", "laudelina.bueno@gmail.com");

    repositorioUsuario.saveAll(Arrays.asList(barbara, jean, laudelina));
  } 
}