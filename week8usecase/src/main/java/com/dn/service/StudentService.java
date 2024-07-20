package com.dn.service;

import java.util.List;

import com.dn.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    Student saveStudent(Student student);

    Student updateStudent(Integer id, Student student);

    void deleteStudent(Integer id);
}