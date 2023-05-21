package com.boris.bean;

import lombok.*;

/**
 * @author liyong
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private int age;

    private Pet pet;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
