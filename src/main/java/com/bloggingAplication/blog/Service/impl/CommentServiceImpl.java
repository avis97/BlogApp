package com.bloggingAplication.blog.Service.impl;

import com.bloggingAplication.blog.Converter.CommentConverter;
import com.bloggingAplication.blog.Converter.PostConverter;
import com.bloggingAplication.blog.Dtos.CommentRequestDto;
import com.bloggingAplication.blog.Dtos.CommentResponseDto;
import com.bloggingAplication.blog.Dtos.PostResponseDto;
import com.bloggingAplication.blog.Entity.Category;
import com.bloggingAplication.blog.Entity.Comments;
import com.bloggingAplication.blog.Entity.Post;
import com.bloggingAplication.blog.Entity.User;
import com.bloggingAplication.blog.Exception.CategoryNotFoundException;
import com.bloggingAplication.blog.Exception.PostNotFoundException;
import com.bloggingAplication.blog.Exception.UserNotFoundException;
import com.bloggingAplication.blog.Repository.CommentsRepository;
import com.bloggingAplication.blog.Repository.PostRepository;
import com.bloggingAplication.blog.Repository.UserRepository;
import com.bloggingAplication.blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

      @Autowired
      PostRepository postRepository;
      @Autowired
      UserRepository userRepository;
      @Autowired
      CommentsRepository  commentsRepository;

      public CommentResponseDto addComment(CommentRequestDto commentRequestDto) throws UserNotFoundException, PostNotFoundException {
          User user;
          Post post;
          try{
              user=userRepository.findById(commentRequestDto.getUserId()).get();
          }catch(Exception e){
              throw new UserNotFoundException("Invalid User id");
          }

          try{
              post=postRepository.findById(commentRequestDto.getPostId()).get();
          }catch(Exception e){
              throw new PostNotFoundException("Invalid Post Id!!!");
          }
          Comments comments=new Comments();
          comments.setCommentContent(commentRequestDto.getContent());
          comments.setUser(user);
          comments.setPost(post);

          List<Comments> postCommentsList=post.getCommentsList();
          postCommentsList.add(comments);

          List<Comments> userCommentsList=user.getCommentsList();
          userCommentsList.add(comments);

          commentsRepository.save(comments);

          CommentResponseDto dto=new CommentResponseDto();
          dto.setContent(comments.getCommentContent());
          dto.setPostId(comments.getPost().getPostId());
          dto.setUserId(comments.getUser().getId());
          dto.setTime(comments.getDateTime());

          return dto;
      }
    public List<CommentResponseDto> getAllComment() throws PostNotFoundException {
          List<Comments> commentsList=commentsRepository.findAll();

          List<CommentResponseDto> comments=new ArrayList<>();
          for(Comments key:commentsList){
              CommentResponseDto comment= CommentConverter.commentToCommentResponseDto(key);
              Post post;
              PostResponseDto responseDto;
              try {
                  post = postRepository.findById(key.getPost().getPostId()).get();
                  responseDto=PostConverter.postToPostResponseDto(post);
              }
              catch (Exception e){
                  throw new PostNotFoundException("Post is not found");
              }
              comment.setPostResponseDto(responseDto);
              comments.add(comment);
          }
          return comments;
    }
}
