package com.microservice.course.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StudentDTO {

    private String name;
    private String lastName;
    private String email;
    private Long courseId;
}
