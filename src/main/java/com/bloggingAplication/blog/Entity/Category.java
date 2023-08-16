package com.bloggingAplication.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;
    private String title;
    private String details;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    List<Post> postList=new ArrayList<>();
}
