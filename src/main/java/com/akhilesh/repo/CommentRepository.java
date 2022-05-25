package com.akhilesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
