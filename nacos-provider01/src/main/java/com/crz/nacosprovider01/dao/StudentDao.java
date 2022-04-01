package com.crz.nacosprovider01.dao;

import com.crz.nacosprovider01.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface StudentDao {

    Student queryById(Integer id);

    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Student> queryAll();

    int insert(Student student);

    int update(Student student);

    int deleteById(Integer id);

}