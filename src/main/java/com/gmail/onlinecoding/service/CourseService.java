package com.gmail.onlinecoding.service;

import com.gmail.onlinecoding.controller.dto.Course;
import com.gmail.onlinecoding.exceptions.CourseNotFoundException;
import com.gmail.onlinecoding.model.CourseEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CourseService {
    void create(CourseEntity entity);
    CourseEntity findById(Long id) throws CourseNotFoundException;
    List<CourseEntity> findAll();
    void delete(Long id);
    CourseEntity update(Long id, Course course);
    List<CourseEntity> findByNameLike(Specification<CourseEntity> specification);
}
