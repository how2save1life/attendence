package com.example.attendence.service;

import com.example.attendence.entity.Teacher;

import java.util.List;

public interface TeacherService {
    String saveOne(Teacher teacher);
    String deleteOne(String teacherId);
    String updateTeacher(Teacher teacher);
    Teacher findOne(String teacherceId);
    List<Teacher> findAll(int pagenum, int pagesize);
    Long findpagesum(int pagesize);

    String login(Teacher teacher);
}
