package com.gmail.onlinecoding.model.listener;

import com.gmail.onlinecoding.model.superclasses.CreatableEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreatedDateListener {
    @PrePersist
    public void setDate(CreatableEntity date){
        date.setCreatedDate(new Date().getTime());
    }
}
