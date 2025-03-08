package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface BlogInterface {
    Blog add(Blog blog);

    List<Blog> get();

    Blog get(Integer Id);
}
