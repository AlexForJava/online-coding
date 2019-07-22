package com.gmail.onlinecoding.controller;

import com.gmail.onlinecoding.controller.dto.Course;
import com.gmail.onlinecoding.controller.requests.SpecificationRequest;
import com.gmail.onlinecoding.mapper.CourseMapper;
import com.gmail.onlinecoding.service.CourseService;
import com.gmail.onlinecoding.service.specification.SpecificationCreator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final SpecificationCreator specificationCreator;

    @GetMapping
    public List<Course> getAll() {
        return courseMapper.buidlListCourse(courseService.findAll());
    }

    @PostMapping
    public List<Course> create(@RequestBody Course course) {
        courseService.create(courseMapper.createNewEntity(course));
        return courseMapper.buidlListCourse(courseService.findAll());
    }

    @PutMapping(path = "/{id}")
    public Course update(@RequestBody Course course, @PathParam("id") Long id) {
        return courseMapper.buildDto(courseService.update(id, course));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        courseService.delete(Long.valueOf(id));
    }

    @PostMapping(path = "/search")
    public List<Course> findCourseByNameLike(@RequestBody SpecificationRequest request){
        return courseMapper.buidlListCourse(courseService.findByNameLike(specificationCreator.hasNameLike(request.getName())));
    }
}
