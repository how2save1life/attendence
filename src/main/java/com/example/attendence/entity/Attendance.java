package com.example.attendence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Attendance {
    private String attendanceId;
    private String studentId;
    private String courseId;
    private Timestamp time;
    private String attendanceStates;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "attendance_id", nullable = false, length = 255)
    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    @Basic
    @Column(name = "student_id", nullable = true, length = 255)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "course_id", nullable = true, length = 255)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "attendance_states", nullable = true, length = 255)
    public String getAttendanceStates() {
        return attendanceStates;
    }

    public void setAttendanceStates(String attendanceStates) {
        this.attendanceStates = attendanceStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(attendanceId, that.attendanceId) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(time, that.time) &&
                Objects.equals(attendanceStates, that.attendanceStates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendanceId, studentId, courseId, time, attendanceStates);
    }
}
