package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Enrollment;
import com.nucleo1Ejercicio.gestionAcademica.model.Student;
import com.nucleo1Ejercicio.gestionAcademica.model.Course;
import com.nucleo1Ejercicio.gestionAcademica.service.EnrollmentService;
import com.nucleo1Ejercicio.gestionAcademica.service.StudentService;
import com.nucleo1Ejercicio.gestionAcademica.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listEnrollments(Model model) {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        List<Student> students = studentService.getAllStudents();
        List<Course> courses = courseService.getAllCourses();

        model.addAttribute("enrollments", enrollments);
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "enrollments";
    }

    @GetMapping("/edit/{id}")
    public String editEnrollment(@PathVariable("id") Long id, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        List<Student> students = studentService.getAllStudents();
        List<Course> courses = courseService.getAllCourses();

        model.addAttribute("enrollment", enrollment != null ? enrollment : new Enrollment());
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "enrollments";
    }

    @PostMapping
    public String saveEnrollment(@ModelAttribute("enrollment") Enrollment enrollment) {
        if (enrollment.getEnrollmentId() != null) {
            enrollmentService.updateEnrollment(enrollment.getEnrollmentId(), enrollment);
        } else {
            enrollmentService.createEnrollment(enrollment);
        }
        return "redirect:/enrollments";
    }

    @GetMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable("id") Long id) {
        enrollmentService.deleteEnrollment(id);
        return "redirect:/enrollments";
    }
}
