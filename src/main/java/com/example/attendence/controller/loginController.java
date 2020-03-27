package com.example.attendence.controller;

import com.example.attendence.entity.Student;
import com.example.attendence.entity.Teacher;
import com.example.attendence.service.StudentService;
import com.example.attendence.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/teacher")
    public String teacherLogin(@RequestBody Teacher teacher){
        return teacherService.login(teacher);
    }
    @PostMapping("/student")
    public String studentLogin(@RequestBody Student student){
        return studentService.login(student);
    }
//    @PostMapping("/admin")
//    public String teacherLogin(@RequestBody Teacher teacher){
//        return teacherService.login(teacher);
//    }
}
