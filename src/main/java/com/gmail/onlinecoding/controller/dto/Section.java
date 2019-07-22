package com.gmail.onlinecoding.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Section extends CreatableDto {
    private String name;
    private Course course;
}
