package com.nucleo1Ejercicio.gestionAcademica.service;

import com.nucleo1Ejercicio.gestionAcademica.model.Enrollment;
import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(Long id);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(Long id, Enrollment enrollment);
    void deleteEnrollment(Long id);
}