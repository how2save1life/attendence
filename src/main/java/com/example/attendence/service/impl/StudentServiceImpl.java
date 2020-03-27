package com.example.attendence.service.impl;

import com.example.attendence.dao.StudentDao;
import com.example.attendence.entity.Student;
import com.example.attendence.entity.Teacher;
import com.example.attendence.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public String login(Student student) {
        boolean flag = false;
        Student a = studentDao.findOneByStudentIdAndStudentPasswd(student.getStudentId(), student.getStudentPasswd());
        if (a != null)
            flag = true;
        return flag ? "success" : "failed";
    }

    @Override
    public String saveOne(Student student) {
        boolean flag = false;
        if(student.getStudentId()==null|| student.getStudentId().equals("")){//传空值
            return "info_needed";
        }
        if (studentDao.findOneByStudentId(student.getStudentId()) == null) {//id未重複
            try {
                studentDao.save(student);//
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
    public String deleteOne(String studentId) {
        boolean flag = false;
        Student student = findOne(studentId);
        if (student != null) {//存在
            try {
                studentDao.deleteByStudentId(studentId);
                flag = true;
            } catch (Exception e) {
                System.out.println("delete student failed" + e.getMessage());
            }
        } else {
            return "not_existed";
        }

        return flag ? "success" : "failed";
    }

    @Override
    public String updateStudent(Student student) {
        boolean flag = false;
        String studentId = student.getStudentId();
        String studentName = student.getStudentName();
        String studentCollege = student.getStudentCollege();

        try {
            studentDao.updateStudent(studentId,studentName, studentCollege);
            flag = true;
        } catch (Exception e) {
            System.out.println("updateStudent failed" + e.getMessage());
        }
        return flag ?"success":"failed";
    }

    @Override
    public Student findOne(String studentceId) {
        return studentDao.findOneByStudentId(studentceId);
    }

    @Override
    public List<Student> findAll(int pagenum, int pagesize) {

        List<Student> list = studentDao.findAll();
        System.out.println(list);
        List<Student> pagelist = new ArrayList<Student>();
        if (list.size()<pagenum*pagesize){
            for (int i=(list.size()/pagesize )*pagesize;i<list.size();i++)
                pagelist.add(list.get(i));
        }
        else{
            for (int i=(pagenum-1)*pagesize;i<pagenum*pagesize;i++)
                pagelist.add(list.get(i));
        }
        return pagelist;
    }

    @Override
    public Long findpagesum(int pagesize) {
        Long students = studentDao.countBystudentId();
        System.out.println(students);
        Long pages=students/pagesize;
        if (students%pagesize!=0)
            pages++;
        return pages;
    }




}
