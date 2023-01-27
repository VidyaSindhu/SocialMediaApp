package com.vsd.SocialMediaApp.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAllByUser_Id(Integer id);
}
