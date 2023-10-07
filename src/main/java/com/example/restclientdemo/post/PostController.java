package com.example.restclientdemo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
     private final PostService postService;

     @Autowired
     public PostController(PostService postService) {
         this.postService = postService;
    }

    @GetMapping ("")
     public List<Post> getAllPost(){
         return postService.getAllPost();
     }

    @GetMapping ("/{id}")
    public Post getAllPost(@PathVariable Integer id){
        return postService.getPostById(id);
    }

}
