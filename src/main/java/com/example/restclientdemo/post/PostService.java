package com.example.restclientdemo.post;


import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;


@Service
public class PostService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);
    private final  RestTemplate restTemplate;

    public PostService(RestTemplateBuilder restTemplateBuilder) {
        LOGGER.info("PostService created");
        this.restTemplate = restTemplateBuilder.rootUri("https://jsonplaceholder.typicode.com").build();
    }


    public List<Post> getAllPost(){
        LOGGER.info("getAllPost called");
        return List.of(Objects.requireNonNull(restTemplate.getForObject("/posts", Post[].class)));
    }

    public Post getPostById(Integer id) {
        LOGGER.info("getPostById called");
        return restTemplate.getForObject("/posts/{id}", Post.class, id);
    }
}
