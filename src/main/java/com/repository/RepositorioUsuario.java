package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {}