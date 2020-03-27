package com.example.attendence.controller;

import com.example.attendence.entity.Student;
import com.example.attendence.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Student", produces = {"application/json;charset=UTF-8"})
public class studentController {
    private int pagesize=10;
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> findAllStudent(@RequestParam(value = "page",defaultValue = "1") int pagenum) {
        List<Student> pt = studentService.findAll(pagenum, pagesize);
        if (pt != null && pt.size()>0)
            return pt;
        return null;
    }
    @GetMapping("/pagesum")
    public Long getpagesum(){
        return studentService.findpagesum(pagesize);
    }

    @PostMapping("update")
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam(value = "studentId")String studentId){
        return studentService.deleteOne(studentId);
    }

    @PostMapping ("/save")
    public String saveStudent(@RequestBody Student student){
        return studentService.saveOne(student);
    }
}
