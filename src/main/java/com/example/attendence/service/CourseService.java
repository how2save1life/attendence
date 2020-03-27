package com.example.attendence.service;

import com.example.attendence.entity.Course;

import java.util.List;

public interface CourseService {
    String saveOne(Course course);
    String deleteOne(String courseId);
    String updateCourse(Course course);
    Course findOne(String courseId);

    List<Course> findAll(int pagenum, int pagesize);
    Long findpagesum(int pagesize);

    List<Course> findCourse(String teacherId);
}
