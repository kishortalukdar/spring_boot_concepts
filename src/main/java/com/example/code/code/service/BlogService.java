package com.example.code.code.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.code.code.model.Blog;
import com.example.code.code.repository.BlogRepository;

// import com.example.code.code.model.Blog;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    // // Constructor-based injection
    // public BlogService(BlogRepository blogRepository) {
    //     this.blogRepository = blogRepository;
    // }
    
    // Create a new post
     public Blog createPost(Blog blog) {
        return blogRepository.save(blog);
    }

    // Get all posts
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    // Get a single post by ID
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    // Update a blog post
    public Blog updatePost(Long id, Blog updateBlog) {
        return blogRepository.findById(id).map(blog -> {
            // Update the fields of the blog
            blog.setTitle(updateBlog.getTitle());
            blog.setDescriptions(updateBlog.getDescriptions());
            return blogRepository.save(blog); // Save the updated blog
        }).orElseThrow(() -> new RuntimeException("Blog not found for id: " + id));
    }


    
     // Delete a post
    public void deletePost(Long id) {
        blogRepository.deleteById(id);
    }


}
