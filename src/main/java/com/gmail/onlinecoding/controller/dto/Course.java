package com.gmail.onlinecoding.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Course extends CreatableDto{
    private String name;
    private Integer cost;
    private List<Section> sectionList = new ArrayList<>();
}
