package com.example.springboottodo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Boolean starred;
}
