package com.sun.dev.entity;

import lombok.Data;

@Data
public class Book {
    private Integer ID;
    private String name;
    private Integer pageCount;
    private Author author;
}
