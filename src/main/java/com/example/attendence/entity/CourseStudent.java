package com.example.attendence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_student", schema = "attendance"/*, catalog = ""*/)
public class CourseStudent {
    private int csId;
    private String studentId;
    private String courseId;

    @Id
    @GeneratedValue
    @Column(name = "cs_id", nullable = false)
    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    @Basic
    @Column(name = "student_id", nullable = false, length = 255)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "course_id", nullable = false, length = 255)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStudent that = (CourseStudent) o;
        return csId == that.csId &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csId, studentId, courseId);
    }
}
