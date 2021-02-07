package com.example.petproject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String password;

    public User(Long id) {
        this.id = id;
    }
}
