

package com.example.code.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.code.code.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

    
}