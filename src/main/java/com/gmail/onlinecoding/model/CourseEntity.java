package com.gmail.onlinecoding.model;

import com.gmail.onlinecoding.model.superclasses.CreatableEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "course")
public class CourseEntity extends CreatableEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<SectionEntity> sections = new ArrayList<>();

    public CourseEntity setId(Long id){
        this.id = id;
        return this;
    }
}
