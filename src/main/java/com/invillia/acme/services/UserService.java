package com.invillia.acme.services;

import com.invillia.acme.models.User;
import com.invillia.acme.models.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
