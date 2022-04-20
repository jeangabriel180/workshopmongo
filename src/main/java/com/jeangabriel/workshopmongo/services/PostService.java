package com.jeangabriel.workshopmongo.services;

import com.jeangabriel.workshopmongo.domain.Post;
import com.jeangabriel.workshopmongo.repository.PostRepository;
import com.jeangabriel.workshopmongo.services.exception.ObjectNotFoundExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundExpection("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
