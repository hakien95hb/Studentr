package com.manager.student.service;
import com.manager.student.entity.Student;
import com.manager.student.reponsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentServiceImplement implements StudentService{
    @Autowired
    private StudentReponsitory studentReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Student> getList(int page, int limit) {
        return studentReponsitory.findAll(PageRequest.of(page -1, limit));
    }

    @Override
    public Student getDetail(String email) {
        return studentReponsitory.findById(email).orElse(null);
    }


    @Override
    public Student login(String email, String password) {

        // Tìm tài khoản có email trùng xem tồn tại không.
        Optional<Student> optionalAccount = studentReponsitory.findById(email);
        if (optionalAccount.isPresent()) {
            // So sánh password xem trùng không (trong trường hợp pwd đã mã hoá thì phải mã hoá pwd truyền vào theo muối)
            Student student = optionalAccount.get();
            if (student.getPassword().equals(password.equals(passwordEncoder.encode(student.getPassword())))) {
                return student;
            }
        }
        return null;
    }


    @Override
    public Student register(Student student) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentReponsitory.save(student);
    }

    @Override
    public Student update(String email, Student student) {

        Optional<Student> optionalStudent = studentReponsitory.findById(email);
        if (optionalStudent == null){
            Student existStudent = optionalStudent.get();
            existStudent.setName(student.getName());
            existStudent.setPassword(student.getPassword());
            existStudent.setEmail(student.getEmail());
            existStudent.setCodeStudent(student.getCodeStudent());
            return studentReponsitory.save(student);

        }
        return null;
    }

    @Override
    public Student getByEmail(String email) {
        return studentReponsitory.findById(email).orElse(null);
    }
}
