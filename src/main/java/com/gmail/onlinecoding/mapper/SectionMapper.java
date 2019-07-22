package com.gmail.onlinecoding.mapper;

import com.gmail.onlinecoding.controller.dto.Section;
import com.gmail.onlinecoding.model.SectionEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
public class SectionMapper {
    public Section buildDto(SectionEntity entity){
        Section section = new Section();
        section.setId(entity.getId());
        section.setLocalDateTime(LocalDateTime
                .ofInstant(Instant.ofEpochMilli(entity.getCreatedDate()),
                        TimeZone.getDefault().toZoneId()));
        section.setName(entity.getName());

        return section;
    }
}
