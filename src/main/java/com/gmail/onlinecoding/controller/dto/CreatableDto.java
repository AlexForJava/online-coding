package com.gmail.onlinecoding.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreatableDto extends BaseDto{
    private LocalDateTime localDateTime;
}
