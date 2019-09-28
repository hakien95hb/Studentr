package com.manager.student.service;

import com.manager.student.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService {


    Page<Student> getList(int page, int limit);

    Student getDetail(String email);

    Student login(String email, String password);

    Student register(Student student);

    Student update(String email ,Student student);

    Student getByEmail(String email);


}
