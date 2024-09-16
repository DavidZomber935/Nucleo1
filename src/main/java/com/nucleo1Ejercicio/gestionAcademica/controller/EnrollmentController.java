package com.nucleo1Ejercicio.gestionAcademica.controller;

import com.nucleo1Ejercicio.gestionAcademica.model.Enrollment;
import com.nucleo1Ejercicio.gestionAcademica.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment != null) {
            return new ResponseEntity<>(enrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
        return new ResponseEntity<>(newEnrollment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);
        if (updatedEnrollment != null) {
            return new ResponseEntity<>(updatedEnrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
