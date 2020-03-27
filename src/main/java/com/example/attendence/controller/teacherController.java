package com.example.attendence.controller;

import com.example.attendence.entity.Teacher;
import com.example.attendence.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Teacher", produces = {"application/json;charset=UTF-8"})
public class teacherController {
    private int pagesize=10;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher(@RequestParam(value = "page",defaultValue = "1") int pagenum) {
        List<Teacher> pt = teacherService.findAll(pagenum, pagesize);
        if (pt != null && pt.size()>0)
            return pt;
        return null;
    }

    @GetMapping("/pagesum")
    public Long getpagesum(){
        return teacherService.findpagesum(pagesize);
    }

    @PostMapping("update")
    public String updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam(value = "teacherId")String teacherId){
        return teacherService.deleteOne(teacherId);
    }

    @PostMapping ("/save")
    public String saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveOne(teacher);
    }



}
