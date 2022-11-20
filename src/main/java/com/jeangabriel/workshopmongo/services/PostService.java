package com.jeangabriel.workshopmongo.services;

import com.jeangabriel.workshopmongo.domain.Post;
import com.jeangabriel.workshopmongo.domain.User;
import com.jeangabriel.workshopmongo.dto.UserDTO;
import com.jeangabriel.workshopmongo.repository.PostRepository;
import com.jeangabriel.workshopmongo.repository.UserRepository;
import com.jeangabriel.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

}
