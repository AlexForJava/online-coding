package com.gmail.onlinecoding.service.specification;

import com.gmail.onlinecoding.model.CourseEntity;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationCreator {
    Specification<CourseEntity> hasNameLike(String name);
}
