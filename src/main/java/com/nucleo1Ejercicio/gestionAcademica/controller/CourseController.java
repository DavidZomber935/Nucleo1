package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Course;
import com.nucleo1Ejercicio.gestionAcademica.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new Course());
        return "courses";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course != null ? course : new Course());
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @PostMapping
    public String saveCourse(@ModelAttribute("course") Course course) {
        if (course.getCourseId() != null) {
            courseService.updateCourse(course.getCourseId(), course);
        } else {
            courseService.createCourse(course);
        }
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
