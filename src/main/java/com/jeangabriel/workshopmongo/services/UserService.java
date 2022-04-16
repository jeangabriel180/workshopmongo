package com.jeangabriel.workshopmongo.services;

import com.jeangabriel.workshopmongo.domain.User;
import com.jeangabriel.workshopmongo.repository.UserRepository;
import com.jeangabriel.workshopmongo.services.exception.ObjectNotFoundExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundExpection("Objeto não encontrado"));
    }
}
