package com.example.registration.Dao;

import com.example.registration.Dto.StudentDto;
import com.example.registration.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    @Query("select new com.example.registration.Dto.StudentDto (syskey, t1, t2, createddate, modifieddate) from Student where recordstatus=:recordstatus")
    List<StudentDto> findAllStudent(int recordstatus);

    @Query("select new com.example.registration.Dto.StudentDto (syskey, t1, t2, createddate, modifieddate) from Student where syskey=:syskey and recordstatus=:recordstatus")
    StudentDto getStudent(long syskey, int recordstatus);

    Boolean existsBySyskeyEqualsAndRecordstatusEquals(long syskey, int recordStatus);
}
