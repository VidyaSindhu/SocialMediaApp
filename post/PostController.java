package com.vsd.SocialMediaApp.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping(value = "/posts")
    public void addPost(@RequestBody Post post){
        System.out.println("here");
        boolean success = postService.addPost(post);
        System.out.println(success);
    }

    @GetMapping(value = "/posts/all")
    public Iterable<Post> getAllPosts(@RequestHeader Integer id){
        System.out.println(id);
        return postService.getAllPosts(id);
    }

    @PostMapping(value = "/posts/comment")
    public void commentOnThePost(@RequestBody Comment comment){
        postService.addCommentOnPost(comment);
    }
}
