package com.nucleo1Ejercicio.gestionAcademica.service.impl;

import com.nucleo1Ejercicio.gestionAcademica.model.Enrollment;
import com.nucleo1Ejercicio.gestionAcademica.repository.EnrollmentRepository;
import com.nucleo1Ejercicio.gestionAcademica.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(id);
        return enrollment.orElse(null);
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        if (enrollmentRepository.existsById(id)) {
            enrollment.setEnrollmentId(id);
            return enrollmentRepository.save(enrollment);
        }
        return null;
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
