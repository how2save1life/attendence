package com.example.attendence.dao;

import com.example.attendence.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    List<Teacher> findAll();

    @Query(value="select count(*) from teacher ", nativeQuery = true)
    Long countByteacherId();

    @Transactional
    @Modifying
    @Query(value="update Teacher t set t.teacherName=:teacherName,t.teacherCollege=:teacherCollege where t.teacherId=:teacherId")
    int updateTeacher(@Param("teacherId") String teacherId,@Param("teacherName")  String teacherName,@Param("teacherCollege")  String teacherCollege);

    @Transactional
    int deleteByTeacherId(String teacherId);

    Teacher findOneByTeacherId(String teacherId);

    Teacher findOneByTeacherIdAndTeacherPasswd(String teacherId, String teacherPasswd);
}
