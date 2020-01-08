package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = true,length = 20)
    private String name;
    @Column(name = "age", nullable = true,length = 20)
    private Integer age;
}
