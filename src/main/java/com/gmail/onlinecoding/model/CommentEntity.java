package com.gmail.onlinecoding.model;

import com.gmail.onlinecoding.model.superclasses.CreatableEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "comment")
public class CommentEntity extends CreatableEntity {
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    @Column(name = "content")
    private String content;

    @Column(name = "author_id")
    private Long authorId;
}
