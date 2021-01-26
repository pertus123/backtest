package com.common.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.project.model.post.Post;

public interface PostDao extends JpaRepository<Post, Long>, PostRepository {


}
