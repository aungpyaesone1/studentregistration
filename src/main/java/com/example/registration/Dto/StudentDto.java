package com.example.registration.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class StudentDto {
    private long id;
    private String name;
    private String className;
    private String createddate;
    private String modifieddate;
}
