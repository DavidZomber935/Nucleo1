package com.nucleo1Ejercicio.gestionAcademica.controller;
import com.nucleo1Ejercicio.gestionAcademica.model.Classroom;
import com.nucleo1Ejercicio.gestionAcademica.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
        Classroom classroom = classroomService.getClassroomById(id);
        if (classroom != null) {
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        Classroom newClassroom = classroomService.createClassroom(classroom);
        return new ResponseEntity<>(newClassroom, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
        Classroom updatedClassroom = classroomService.updateClassroom(id, classroom);
        if (updatedClassroom != null) {
            return new ResponseEntity<>(updatedClassroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
