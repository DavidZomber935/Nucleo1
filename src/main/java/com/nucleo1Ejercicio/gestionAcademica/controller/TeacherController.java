package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Teacher;
import com.nucleo1Ejercicio.gestionAcademica.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        if (updatedTeacher != null) {
            return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}