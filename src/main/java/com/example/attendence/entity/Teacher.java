package com.example.attendence.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Teacher {
    private String teacherId;
    private String teacherName;
    private String teacherCollege;
    private String teacherPasswd="123456";

    @Id
    @Column(name = "teacher_id", nullable = false, length = 255)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacher_name", nullable = true, length = 255)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "teacher_college", nullable = true, length = 255)
    public String getTeacherCollege() {
        return teacherCollege;
    }

    public void setTeacherCollege(String teacherCollege) {
        this.teacherCollege = teacherCollege;
    }

    @Basic
    @Column(name = "teacher_passwd", nullable = true, length = 255)
    public String getTeacherPasswd() {
        return teacherPasswd;
    }

    public void setTeacherPasswd(String teacherpasswd) {
        this.teacherPasswd = teacherpasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherId, teacher.teacherId) &&
                Objects.equals(teacherName, teacher.teacherName) &&
                Objects.equals(teacherCollege, teacher.teacherCollege) &&
                Objects.equals(teacherPasswd, teacher.teacherPasswd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, teacherCollege, teacherPasswd);
    }
}
