package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Student;
import com.nucleo1Ejercicio.gestionAcademica.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        return "students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student != null ? student : new Student());
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        if (student.getStudentId() != null) {
            studentService.updateStudent(student.getStudentId(), student);
        } else {
            studentService.createStudent(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}