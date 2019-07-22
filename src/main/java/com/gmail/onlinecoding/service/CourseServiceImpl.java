package com.gmail.onlinecoding.service;

import com.gmail.onlinecoding.controller.dto.Course;
import com.gmail.onlinecoding.exceptions.CourseNotFoundException;
import com.gmail.onlinecoding.model.CourseEntity;
import com.gmail.onlinecoding.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void create(CourseEntity entity) {
        courseRepository.save(entity);
    }

    @Override
    public CourseEntity findById(Long id) throws CourseNotFoundException {
        return courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseEntity update(Long id, Course course) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(RuntimeException::new);
        courseEntity.setCost(course.getCost())
                .setName(course.getName());
        return courseRepository.save(courseEntity);
    }

    @Override
    public List<CourseEntity> findByNameLike(Specification<CourseEntity> specification) {
        return courseRepository.findAll(specification);
    }
}
