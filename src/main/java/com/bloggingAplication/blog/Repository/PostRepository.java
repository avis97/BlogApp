package com.bloggingAplication.blog.Repository;

import com.bloggingAplication.blog.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

}
