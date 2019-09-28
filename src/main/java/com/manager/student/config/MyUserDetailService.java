package com.manager.student.config;

import com.manager.student.entity.Student;
import com.manager.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentService accountService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = accountService.getByEmail(email);
        if (student == null){
            throw  new  UsernameNotFoundException("User not fount");
        }
        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .build();
    }
}
