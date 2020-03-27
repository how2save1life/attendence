package com.example.attendence.dao;

import com.example.attendence.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceDao extends JpaRepository<Attendance,Integer> {
    @Override
    List<Attendance> findAll();
}
