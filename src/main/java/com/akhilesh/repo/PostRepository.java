package com.akhilesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
