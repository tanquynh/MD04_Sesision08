package com.lecture.model.service;

import com.lecture.model.dao.StudentDAOImp;
import com.lecture.model.entity.Student;

import java.util.List;

public class StudentService implements IGenericService<Student, Integer>{
    private final StudentDAOImp studentDAOImp = new StudentDAOImp();
    @Override
    public List<Student> findAll() {
        return studentDAOImp.findAll();
    }

    @Override
    public Boolean save(Student student) {
        return studentDAOImp.save(student);
    }

    @Override
    public Student findId(Integer studentCode) {
        Student student = studentDAOImp.findId(studentCode);
        return student;
    }

    @Override
    public Boolean update(Student student, Integer studentCode) {

        return studentDAOImp.update(student, studentCode);
    }

    @Override
    public void delete(Integer studentCode) {
        studentDAOImp.delete(studentCode);
    }
}
