package com.example.registration.Controller;

import com.example.registration.Dto.StudentDto;
import com.example.registration.Service.StudentService;
import com.example.registration.Util.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto student){
        Map<String, Object> res=new HashMap<String, Object>();
        if(student == null){
            res.put("status", Setting.invalid_request_code);
            res.put("message", "Invalid object");
            return ResponseEntity.badRequest().body(res);
        }
        long syskey = studentService.saveStudent(student);
        res.put("status", Setting.success_code);
        res.put("message", "Successfully saved");
        res.put("syskey", syskey);
        return ResponseEntity.ok().body(res);

    }

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<?> getStudentList(){
        Map<String, Object> res=new HashMap<String, Object>();
        res.put("status", Setting.success_code);
        res.put("data",studentService.getStudentList());
        return ResponseEntity.ok().body(res);
    }

    @PutMapping(path = "")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto){
        Map<String, Object> res=new HashMap<String, Object>();
        if(!studentService.isExist(studentDto.getId(),1)){
            res.put("status", Setting.invalid_request_code);
            res.put("message", "Does not exist");
            return ResponseEntity.badRequest().body(res);
        }
        long syskey = studentService.saveStudent(studentDto);
        res.put("status", Setting.success_code);
        res.put("message", "Successfully updated");
        res.put("syskey", syskey);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        Map<String, Object> res=new HashMap<String, Object>();
        if(!studentService.isExist(id, 1)){
            res.put("status", Setting.request_item_not_found_code);
            res.put("message", "Does not exist");
            return ResponseEntity.badRequest().body(res);
        }
        StudentDto student = studentService.getStudent(id);
        res.put("status", Setting.success_code);
        res.put("message", "Success");
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
        Map<String, Object> res=new HashMap<String, Object>();
        if(!studentService.isExist(id,1)){
            res.put("status", Setting.request_item_not_found_code);
            res.put("message", "Does not exist");
            return ResponseEntity.badRequest().body(res);
        }
        long syskey = studentService.deleteStudent(id);
        res.put("status", Setting.success_code);
        res.put("message", "Successfully deleted");
        res.put("syskey", syskey);
        return ResponseEntity.ok().body(res);
    }
}
