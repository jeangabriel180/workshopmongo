package com.jeangabriel.workshopmongo.resources;

import com.jeangabriel.workshopmongo.domain.User;
import com.jeangabriel.workshopmongo.dto.UserDTO;
import com.jeangabriel.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    //"RequestMapping"
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(user ->
                new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
