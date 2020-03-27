package com.example.attendence.dao;
import com.example.attendence.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseDao extends JpaRepository<Course,Integer> {
    List<Course> findAll();
    @Query(value="select count(*) from course ", nativeQuery = true)
    Long countBycourseId();

    @Transactional
    int deleteByCourseId(String courseId);

    Course findOneByCourseId(String courseId);

    @Transactional
    @Modifying
    @Query(value = "update course as c set c.course_name = ?2 ,c.course_type=?3,c.course_period=?4,c.course_credit=?5,c.course_addr=?6,c.course_teacher=?7,c.course_week=?8 where c.course_id=?1",nativeQuery=true)
    int updateCourse(String courseId, String courseName, String courseType, String coursePeriod, String courseCredit, String courseAddr, String courseTeacher, String courseWeek);

    List<Course> findAllBycourseTeacher(String teacherId);

//    @Transactional
//    @Modifying
//    @Query(value = "update Course as c set c.courseName = :courseName ,c.courseType=:courseType,c.coursePeriod=:coursePeriod,c.courseCredit=:courseCredit,c.courseAddr=:courseAddr,c.courseTeacher=:courseTeacher where c.courseId=:courseId")
//    int updateCourse(@Param("courseId")String courseId, @Param("courseName")String courseName,@Param("courseType") String courseType, @Param("coursePeriod")String coursePeriod,@Param("courseCredit") String courseCredit, @Param("courseAddr")String courseAddr, @Param("courseTeacher")String courseTeacher);


}
