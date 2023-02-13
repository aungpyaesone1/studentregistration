package com.example.registration.Controller;

import com.example.registration.Dto.BaseResponse;
import com.example.registration.Dto.DataMap;
import com.example.registration.Dto.StudentDto;
import com.example.registration.Service.StudentService;
import com.example.registration.Util.ResponseEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto student){
        //Map<String, Object> res=new HashMap<String, Object>();
        BaseResponse res = new BaseResponse();
        if(student == null){
            //res.put("status", Setting.invalid_request_code);
            //res.put("message", "Invalid object");
            res.setStatus_code(ResponseEnum.ResponseCode.INVALID_REQUEST.code());
            res.setStatus_message(ResponseEnum.ResponseMessage.INVALID_REQUEST.message());
            return ResponseEntity.badRequest().body(res);
        }
        long syskey = studentService.saveStudent(student);
        res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        res.setStatus_message(ResponseEnum.ResponseMessage.SAVE_SUCCESS.message());
        res.setSyskey(syskey);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<?> getStudentList() throws JsonProcessingException {
        BaseResponse res = new BaseResponse();
        res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        res.setStatus_message(ResponseEnum.ResponseMessage.SUCCESS.message());
        res.setData(new DataMap<List>(studentService.getStudentList()).get());
        return ResponseEntity.ok().body(res);
    }

    @PutMapping(path = "")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto){
        BaseResponse res = new BaseResponse();
        if(!studentService.isExist(studentDto.getId(),1)){
            res.setStatus_code(ResponseEnum.ResponseCode.NOT_FOUND.code());
            res.setStatus_message(ResponseEnum.ResponseMessage.NOT_FOUND.message());
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        long syskey = studentService.saveStudent(studentDto);
        res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        res.setStatus_message(ResponseEnum.ResponseMessage.UPDATE_SUCCESS.message());
        res.setSyskey(syskey);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        Map<String, Object> res=new HashMap<String, Object>();
        if(!studentService.isExist(id, 1)){
            res.put("status", ResponseEnum.ResponseCode.NOT_FOUND.code());
            res.put("message", ResponseEnum.ResponseMessage.NOT_FOUND.message());
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        StudentDto student = studentService.getStudent(id);
        res.put("status", ResponseEnum.ResponseCode.SUCCESS.code());
        res.put("message", ResponseEnum.ResponseMessage.SUCCESS.message());
        res.put("data", student);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/export")
    public ResponseEntity<?> exportData() throws IOException {
        String filename = "Students.xlsx";
        InputStreamResource file = new InputStreamResource(studentService.exportData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        BaseResponse res = new BaseResponse();
        if(!studentService.isExist(id,1)){
            res.setStatus_code(ResponseEnum.ResponseCode.NOT_FOUND.code());
            res.setStatus_message(ResponseEnum.ResponseMessage.NOT_FOUND.message());
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        long syskey = studentService.deleteStudent(id);
        res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        res.setStatus_message(ResponseEnum.ResponseMessage.DELETE_SUCCESS.message());
        res.setSyskey(syskey);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("test1")
    public ResponseEntity<?> test1(){
        return ResponseEntity.ok().body("Test1");
    }
}
