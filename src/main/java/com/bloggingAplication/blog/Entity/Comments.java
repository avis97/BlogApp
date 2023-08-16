package com.bloggingAplication.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comments")
public class Comments{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int commentId;
    public String commentContent;
    @CreationTimestamp
    public Date dateTime;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
