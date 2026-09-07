package com.priyanshu.student_management_system_3.repository;

import com.priyanshu.student_management_system_3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContainingIgnoreCase(String keyword);
}
