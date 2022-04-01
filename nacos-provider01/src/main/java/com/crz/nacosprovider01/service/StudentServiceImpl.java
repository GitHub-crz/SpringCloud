package com.crz.nacosprovider01.service;


import com.crz.nacosprovider01.entity.Student;
import com.crz.nacosprovider01.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student queryById(Integer id) {
        return this.studentDao.queryById(id);
    }

    @Override
    public List<Student> queryAll(){
        return this.studentDao.queryAll();
    }

    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.studentDao.deleteById(id) > 0;
    }
}
