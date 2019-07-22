package com.gmail.onlinecoding.model.superclasses;

import com.gmail.onlinecoding.model.listener.CreatedDateListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(CreatedDateListener.class)
public class CreatableEntity extends BaseEntity {
    @Column(name = "created_date")
    private Long createdDate;
}
