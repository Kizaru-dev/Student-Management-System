package com.priyanshu.student_management_system_3.service;

import com.priyanshu.student_management_system_3.entity.Student;
import com.priyanshu.student_management_system_3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Save Student .
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    // get Student by id.
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id . "));
    }
    // get All Student .
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    // update Student .
    public Student updateStudent(Student newStudent , Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id . "));
        student.setEmail(newStudent.getEmail());
        student.setName(newStudent.getName());
        student.setPhoneNo(newStudent.getPhoneNo());
        student.setSubject(newStudent.getSubject());
        student.setLastName(newStudent.getLastName());
        return studentRepository.save(student);
    }
    // delete Student .
    public void deleteStudent(Long id){
         studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id .. "));
        studentRepository.deleteById(id);
    }

    // search feature .
    public List<Student> searchStudent(String keyword){
        if(keyword == null || keyword.trim().isEmpty()){
            return studentRepository.findAll();
        }
        return studentRepository.findByNameContainingIgnoreCase(keyword.trim());
    }


}
