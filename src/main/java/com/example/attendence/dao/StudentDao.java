package com.example.attendence.dao;

import com.example.attendence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {

    List<Student> findAll();
    @Query(value="select count(*) from student ", nativeQuery = true)
    Long countBystudentId();

    @Transactional
    @Modifying
    @Query(value="update Student t set t.studentName=:studentName,t.studentCollege=:studentCollege where t.studentId=:studentId")
    int updateStudent(@Param("studentId") String studentId, @Param("studentName")  String studentName, @Param("studentCollege")  String studentCollege);

    @Transactional
    int deleteByStudentId(String studentId);

    Student findOneByStudentId(String StudentId);

    Student findOneByStudentIdAndStudentPasswd(String studentId, String studentPasswd);
}
