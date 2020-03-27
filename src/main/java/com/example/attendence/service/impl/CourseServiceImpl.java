package com.example.attendence.service.impl;

import com.example.attendence.dao.CourseDao;
import com.example.attendence.entity.Course;
import com.example.attendence.entity.Teacher;
import com.example.attendence.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public String saveOne(Course course) {
        boolean flag = false;
        if (course.getCourseId() == null || course.getCourseId().equals("")) {//传空值
            return "info_needed";
        }
        if (courseDao.findOneByCourseId(course.getCourseId()) == null) {//id未重複
            try {
                courseDao.save(course);//
                flag = true;
            } catch (Exception e) {
                System.out.println("failed" + e.getMessage());
            }
        } else {
            System.out.println("already registered");
            return "registered";
        }
        return flag ? "success" : "failed";
    }

    @Override
    public String deleteOne(String courseId) {
        boolean flag = false;
        Course course = findOne(courseId);
        if (course != null) {//存在
            try {
                courseDao.deleteByCourseId(courseId);
                flag = true;
            } catch (Exception e) {
                System.out.println("delete course failed" + e.getMessage());
            }
        } else {
            return "not_existed";
        }

        return flag ? "success" : "failed";
    }

    @Override
    public String updateCourse(Course course) {
        boolean flag = false;
        String courseId = course.getCourseId();
        String courseName = course.getCourseName();
        String courseType = course.getCourseType();
        String coursePeriod = course.getCoursePeriod();
        String courseCredit = course.getCourseCredit();
        String courseAddr = course.getCourseAddr();
        String courseTeacher=course.getCourseTeacher();
        String courseWeek=course.getCourseWeek();

        try {
            courseDao.updateCourse(courseId, courseName, courseType, coursePeriod, courseCredit,
                    courseAddr, courseTeacher,courseWeek);
            flag = true;
        } catch (Exception e) {
            System.out.println("updateCourse failed" + e.getMessage());
        }
        return flag ? "success" : "failed";
    }

    @Override
    public Course findOne(String courseId) {
        return courseDao.findOneByCourseId(courseId);
    }

    @Override
    public List<Course> findAll(int pagenum, int pagesize) {

        List<Course> list = courseDao.findAll();
        System.out.println(list);
        List<Course> pagelist = new ArrayList<Course>();
        if (list.size() < pagenum * pagesize) {
            for (int i = (list.size() / pagesize) * pagesize; i < list.size(); i++)
                pagelist.add(list.get(i));
        } else {
            for (int i = (pagenum - 1) * pagesize; i < pagenum * pagesize; i++)
                pagelist.add(list.get(i));
        }
        return pagelist;
    }

    @Override
    public Long findpagesum(int pagesize) {
        Long courses = courseDao.countBycourseId();
        System.out.println(courses);
        Long pages = courses / pagesize;
        if (courses % pagesize != 0)
            pages++;
        return pages;
    }

    @Override
    public List<Course> findCourse(String teacherId) {
        return courseDao.findAllBycourseTeacher(teacherId);
    }
}
