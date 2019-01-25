package com.invillia.acme.dao;

import com.invillia.acme.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
