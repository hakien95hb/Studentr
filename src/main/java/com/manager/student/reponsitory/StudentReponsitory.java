package com.manager.student.reponsitory;

import com.manager.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentReponsitory extends JpaRepository<Student, String> {

}
