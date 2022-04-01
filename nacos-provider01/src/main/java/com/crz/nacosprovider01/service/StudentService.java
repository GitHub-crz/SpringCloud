package com.crz.nacosprovider01.service;

import com.crz.nacosprovider01.entity.Student;

import java.util.List;

public interface StudentService {

    Student queryById(Integer id);
//    List<Student> queryAll();

    List<Student> queryAll();


    List<Student> queryAllByLimit(int offset, int limit);

    Student insert(Student student);

    Student update(Student student);
    boolean deleteById(Integer id);

}