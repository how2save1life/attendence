package com.example.attendence.service.impl;

import com.example.attendence.dao.AttendanceDao;
import com.example.attendence.entity.Attendance;
import com.example.attendence.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceDao attendanceDao;
    @Override
    public String saveOne(Attendance attendance) {
        return null;
    }

    @Override
    public String deleteOne(String attendanceId) {
        return null;
    }

    @Override
    public String updateAgency(Attendance attendance) {
        return null;
    }

    @Override
    public Attendance findOne(String attendanceId) {
        return null;
    }

    @Override
    public List<Attendance> findAll() {
        return null;
    }
}
