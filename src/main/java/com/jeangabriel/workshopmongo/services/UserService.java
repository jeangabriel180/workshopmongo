package com.jeangabriel.workshopmongo.services;

import com.jeangabriel.workshopmongo.domain.User;
import com.jeangabriel.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
