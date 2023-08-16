package com.bloggingAplication.blog.Repository;

import com.bloggingAplication.blog.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer>{

}
