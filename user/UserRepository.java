package com.vsd.SocialMediaApp.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findUserByEmailEquals(String email);
}
