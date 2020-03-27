package com.example.attendence.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Course {
    private String courseId;
    private String courseName;
    private String courseType;
    private String coursePeriod;
    private String courseCredit;
    private String courseAddr;
    private Integer courseAttTimes=0;
    private String courseTeacher;
    private String courseWeek;

    @Id
    @Column(name = "course_id", nullable = false, length = 255)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name", nullable = false, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_type", nullable = true, length = 255)
    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Basic
    @Column(name = "course_period", nullable = true, length = 255)
    public String getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(String coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    @Basic
    @Column(name = "course_credit", nullable = true, length = 255)
    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Basic
    @Column(name = "course_addr", nullable = true, length = 255)
    public String getCourseAddr() {
        return courseAddr;
    }

    public void setCourseAddr(String courseAddr) {
        this.courseAddr = courseAddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseType, course.courseType) &&
                Objects.equals(coursePeriod, course.coursePeriod) &&
                Objects.equals(courseCredit, course.courseCredit) &&
                Objects.equals(courseAddr, course.courseAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseType, coursePeriod, courseCredit, courseAddr);
    }

    @Basic
    @Column(name = "course_att_times", nullable = true)
    public Integer getCourseAttTimes() {
        return courseAttTimes;
    }

    public void setCourseAttTimes(Integer courseAttTimes) {
        this.courseAttTimes = courseAttTimes;
    }

    @Basic
    @Column(name = "course_teacher", nullable = true, length = 255)
    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Basic
    @Column(name = "course_week", nullable = true, length = 5)
    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek;
    }
}
