package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // Get all blogs
    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.get();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // Get a blog by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id) {
        Blog blog = blogService.get(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a new blog
    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        Blog savedBlog = blogService.add(blog);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Blog>> fetchUserBlog(@PathVariable Integer userId){
        System.out.println("called");
        List<Blog> blogs  = blogService.findBlogsByUserId(userId);
        return new ResponseEntity<>(blogs , HttpStatus.OK);
    }
}
