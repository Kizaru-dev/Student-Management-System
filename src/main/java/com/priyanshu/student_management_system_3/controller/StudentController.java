package com.priyanshu.student_management_system_3.controller;

import com.priyanshu.student_management_system_3.entity.Student;
import com.priyanshu.student_management_system_3.repository.StudentRepository;
import com.priyanshu.student_management_system_3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService ;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String homePage(Model model){
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("students",studentList);
        model.addAttribute("searched",false);
        return "home";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam(required = false) String keyword ,Model model ){
        List<Student> studentList = studentService.searchStudent(keyword);
        model.addAttribute("students",studentList);
        model.addAttribute("keyword",keyword);
        model.addAttribute("searched",true);
        return "home";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "add";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String showEditStudent(Model model , @PathVariable Long id){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@ModelAttribute Student student , @PathVariable Long id){
        studentService.updateStudent(student,id);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
