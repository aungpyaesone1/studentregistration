package com.example.registration.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class StudentDto {
    private long id;
    private String name;
    private String className;
    private String createddate;
    private String modifieddate;

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(String modifieddate) {
        this.modifieddate = modifieddate;
    }

    private StudentDto(){

    }
    public StudentDto(long id, String name, String className, String createddate, String modifieddate) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.createddate = createddate;
        this.modifieddate = modifieddate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
