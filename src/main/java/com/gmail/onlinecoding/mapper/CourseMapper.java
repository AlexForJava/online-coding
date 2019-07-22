package com.gmail.onlinecoding.mapper;

import com.gmail.onlinecoding.controller.dto.Course;
import com.gmail.onlinecoding.controller.dto.Section;
import com.gmail.onlinecoding.model.CourseEntity;
import com.gmail.onlinecoding.model.SectionEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public Course buildDto(CourseEntity entity) {
        Course course = new Course();
        course.setId(entity.getId());
        course.setLocalDateTime(LocalDateTime
                .ofInstant(Instant.ofEpochMilli(entity.getCreatedDate()),
                        TimeZone.getDefault().toZoneId()));
        course.setCost(entity.getCost());
        course.setName(entity.getName());
        course.setSectionList(
                entity.getSections()
                        .stream()
                        .map(this::buildSectionDto).collect(Collectors.toList()));
        return course;
    }

    public CourseEntity createNewEntity(Course course) {
        return new CourseEntity()
                .setCost(course.getCost())
                .setName(course.getName());
    }

    public List<Course> buidlListCourse(List<CourseEntity> entities) {
        return entities
                .stream()
                .map(this::buildDto)
                .collect(Collectors.toList());
    }

    private Section buildSectionDto(SectionEntity entity) {
        Section section = new Section();
        section.setName(entity.getName());
        section.setLocalDateTime(LocalDateTime
                .ofInstant(Instant.ofEpochMilli(entity.getCreatedDate()),
                        TimeZone.getDefault().toZoneId()));
        section.setId(entity.getId());

        return section;
    }

}
