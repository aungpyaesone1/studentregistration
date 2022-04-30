package com.example.registration.Service;

import com.example.registration.Dao.StudentDao;
import com.example.registration.Dto.StudentDto;
import com.example.registration.Entity.Student;
import com.example.registration.Util.ExcelExpoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public long saveStudent(StudentDto studentDto){
        Student student = new Student();
        student.setSyskey(studentDto.getId());
        student.setT1(studentDto.getName());
        student.setT2(studentDto.getClassName());
        student.setRecordstatus(1);
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = dateTime.format(formatter);
        if(student.getSyskey() == 0){
            student.setCreateddate(date);
            student.setModifieddate(date);
        }
        else {
            student.setCreateddate(studentDao.getById(student.getSyskey()).getCreateddate());
            student.setModifieddate(date);
        }
        return studentDao.save(student).getSyskey();
    }

    public List<StudentDto> getStudentList(){
        List<StudentDto> students = studentDao.findAllStudent(1);
        return students;
    }

    public boolean isExist(long syskey, int recordstatus){
        return studentDao.existsBySyskeyEqualsAndRecordstatusEquals(syskey, recordstatus);
    }

    public StudentDto getStudent(long id){
        return studentDao.getStudent(id, 1);
    }

    public ByteArrayInputStream exportData() throws IOException {
        return ExcelExpoter.studentToExcel(getStudentList());
    }

    public long deleteStudent(long id){
        Student student = studentDao.getById(id);
        student.setRecordstatus(4);
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = dateTime.format(formatter);
        student.setModifieddate(date);
        return studentDao.save(student).getSyskey();
    }
}
