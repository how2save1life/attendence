package com.example.attendence.service;

import com.example.attendence.entity.Attendance;
import com.example.attendence.entity.Student;
import com.example.attendence.entity.Teacher;

import java.util.List;

public interface StudentService {
    String saveOne(Student student);
    String deleteOne(String studentId);
    String updateStudent(Student student);
    Student findOne(String studentceId);
    List<Student> findAll(int pagenum, int pagesize);
    Long findpagesum(int pagesize);
    String login(Student student);
}
