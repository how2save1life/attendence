package com.example.attendence.controller;

import com.example.attendence.entity.Course;
import com.example.attendence.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Course", produces = {"application/json;charset=UTF-8"})
public class courseController {
    private int pagesize=10;
    @Autowired
    private CourseService courseService;

    @GetMapping("/findAll")
    public List<Course> findAllCourse(@RequestParam(value = "page",defaultValue = "1") int pagenum) {
        List<Course> pt = courseService.findAll(pagenum, pagesize);
        if (pt != null && pt.size()>0)
            return pt;
        return null;
    }
    @GetMapping("/pagesum")
    public Long getpagesum(){
        return courseService.findpagesum(pagesize);
    }
    @PostMapping("update")
    public String updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam(value = "courseId")String courseId){
        return courseService.deleteOne(courseId);
    }

    @PostMapping ("/save")
    public String saveCourse(@RequestBody Course course){
        return courseService.saveOne(course);
    }

    @GetMapping("/mycourse/teacher")
    public List<Course> findCourse(@RequestParam(value="teacherId")String teacherId){
        return courseService.findCourse(teacherId);
    }
}
