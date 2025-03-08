package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.BlogRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements BlogInterface {

    private final BlogRepo blogRepo;

    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    // Add a new blog
    @Override
    public Blog add(Blog blog) {
        blog.setCreatedDate(LocalDateTime.now());
        return blogRepo.save(blog);
    }

    // Get all blogs
    @Override
    public List<Blog> get() {
        return blogRepo.findAll();
    }

    // Get a blog by ID
    @Override
    public Blog get(Integer id) {
        Optional<Blog> blog = blogRepo.findById(id);
        return blog.orElse(null);
    }

    public List<Blog> findBlogsByUserId(Integer userId) {
        return blogRepo.findAllByUserId(userId);
    }
}
