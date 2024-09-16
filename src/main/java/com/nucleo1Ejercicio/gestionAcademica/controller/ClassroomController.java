package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Classroom;
import com.nucleo1Ejercicio.gestionAcademica.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public String listClassrooms(Model model) {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("classroom", new Classroom());
        return "classrooms";
    }

    @GetMapping("/edit/{id}")
    public String editClassroom(@PathVariable("id") Long id, Model model) {
        Classroom classroom = classroomService.getClassroomById(id);
        model.addAttribute("classroom", classroom != null ? classroom : new Classroom());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
        return "classrooms";
    }

    @PostMapping
    public String saveClassroom(@ModelAttribute("classroom") Classroom classroom) {
        if (classroom.getClassroomId() != null) {
            classroomService.updateClassroom(classroom.getClassroomId(), classroom);
        } else {
            classroomService.createClassroom(classroom);
        }
        return "redirect:/classrooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassroom(@PathVariable("id") Long id) {
        classroomService.deleteClassroom(id);
        return "redirect:/classrooms";
    }
}