package com.gmail.onlinecoding.service.specification;

import com.gmail.onlinecoding.model.CourseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationCreatorImpl implements SpecificationCreator{

    private static final String COLUMN_NAME = "name";

    public Specification<CourseEntity> hasNameLike(String name) {
        return (course, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(course.get(COLUMN_NAME), "%" + name + "%");
    }
}
