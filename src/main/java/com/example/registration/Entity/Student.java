package com.example.registration.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long syskey;
    private String t1;
    private String t2;
    private int recordstatus;
    private String createddate;
    private String modifieddate;
}
