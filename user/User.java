package com.vsd.SocialMediaApp.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vsd.SocialMediaApp.post.Post;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(targetEntity = com.vsd.SocialMediaApp.post.Post.class, cascade = CascadeType.ALL)
    private List<Post> posts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
