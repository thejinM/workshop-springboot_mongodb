package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.domain.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {}