package com.gmail.onlinecoding.model;

import com.gmail.onlinecoding.model.superclasses.CreatableEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "section")
public class SectionEntity extends CreatableEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<LessonEntity> lessons = new ArrayList<>();

    public SectionEntity setId(Long id){
        this.id = id;
        return this;
    }
}
