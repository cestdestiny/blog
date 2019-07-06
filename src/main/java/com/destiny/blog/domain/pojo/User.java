package com.destiny.blog.domain.pojo;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "d_user")
@Getter
@Setter
@Entity
//@ToString
//@Proxy(lazy = false)
public class User extends  BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String  password;

    @Column(name = "email")
    private String email;

    @Column(name = "state")
    private Integer state;

    @Column(name = "img")
    private String img;

    @Column(name = "code")
    private String code;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "d_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =
    @JoinColumn(name = "role_id"))
    private List<Role> roles = Lists.newArrayList();
}
