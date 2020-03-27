package com.example.attendence.service.impl;

import com.example.attendence.dao.TeacherDao;
import com.example.attendence.entity.Teacher;
import com.example.attendence.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    TeacherDao teacherDao;
    @Override
    public String login(Teacher teacher) {
        boolean flag = false;
        Teacher a = teacherDao.findOneByTeacherIdAndTeacherPasswd(teacher.getTeacherId(), teacher.getTeacherPasswd());
        if (a != null)
            flag = true;
        return flag ? "success" : "failed";
    }
    @Override
    public String saveOne(Teacher teacher) {
        boolean flag = false;
        if(teacher.getTeacherId()==null|| teacher.getTeacherId().equals("")){//传空值
            return "info_needed";
        }
        if (teacherDao.findOneByTeacherId(teacher.getTeacherId()) == null) {//id未重複
            try {
                teacherDao.save(teacher);//
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
    public String deleteOne(String teacherId) {
        boolean flag = false;
        Teacher teacher = findOne(teacherId);
        if (teacher != null) {//存在
            try {
                teacherDao.deleteByTeacherId(teacherId);
                flag = true;
            } catch (Exception e) {
                System.out.println("delete teacher failed" + e.getMessage());
            }
        } else {
            return "not_existed";
        }

        return flag ? "success" : "failed";
    }



    @Override
    public Teacher findOne(String teacherceId) {
        return teacherDao.findOneByTeacherId(teacherceId);
    }

    @Override
    public List<Teacher> findAll(int pagenum, int pagesize) {

        List<Teacher> list = teacherDao.findAll();
        System.out.println(list);
        List<Teacher> pagelist = new ArrayList<Teacher>();
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
        Long teachers = teacherDao.countByteacherId();
        System.out.println(teachers);
        Long pages=teachers/pagesize;
        if (teachers%pagesize!=0)
            pages++;
        return pages;
    }

    @Override
    public String updateTeacher(Teacher teacher) {
        boolean flag = false;
        String teacherId = teacher.getTeacherId();
        String teacherName = teacher.getTeacherName();
        String teacherCollege = teacher.getTeacherCollege();

        try {
            teacherDao.updateTeacher(teacherId,teacherName, teacherCollege);
            flag = true;
        } catch (Exception e) {
            System.out.println("updateTeacher failed" + e.getMessage());
        }
        return flag ?"success":"failed";
    }


}
