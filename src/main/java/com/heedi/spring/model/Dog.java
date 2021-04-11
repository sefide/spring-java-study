package com.heedi.spring.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class Dog implements Serializable {

    private String name;
    private int age;
    private String id;
    private transient String nameCode;

    public static Dog empty() {
        return Dog.builder()
                .build();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", nameCode='" + nameCode + '\'' +
                '}';
    }
}

