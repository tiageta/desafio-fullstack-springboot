package com.ford.api.springboot.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String registerDate;
}
