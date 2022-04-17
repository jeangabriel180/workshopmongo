package com.jeangabriel.workshopmongo.repository;

import com.jeangabriel.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //Query methods mongo
    List<Post> findByTitleContainingIgnoreCase(String text);
}
