package com.vsd.SocialMediaApp.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findAllByPost_Id(Integer postId);
}
