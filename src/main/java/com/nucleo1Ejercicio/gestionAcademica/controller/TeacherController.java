package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Teacher;
import com.nucleo1Ejercicio.gestionAcademica.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public String listTeachers(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        model.addAttribute("teacher", new Teacher());
        return "teachers";
    }

    @GetMapping("/edit/{id}")
    public String editTeacher(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher != null ? teacher : new Teacher());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }

    @PostMapping
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        if (teacher.getTeacherId() != null) {
            teacherService.updateTeacher(teacher.getTeacherId(), teacher);
        } else {
            teacherService.createTeacher(teacher);
        }
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}