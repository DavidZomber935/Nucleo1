package com.nucleo1Ejercicio.gestionAcademica.repository;

import com.nucleo1Ejercicio.gestionAcademica.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
