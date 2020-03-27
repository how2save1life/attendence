package com.example.attendence.service;

import com.example.attendence.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    String saveOne(Attendance attendance);
    String deleteOne(String attendanceId);
    String updateAgency(Attendance attendance);
    Attendance findOne(String attendanceId);
    List<Attendance> findAll();

}
