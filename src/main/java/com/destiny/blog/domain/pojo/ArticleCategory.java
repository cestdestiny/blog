package com.destiny.blog.domain.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "d_article_category")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleCategory extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "delete_flag")
    private  Integer deleteFlag;

}
