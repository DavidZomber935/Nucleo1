package com.nucleo1Ejercicio.gestionAcademica.repository;

import com.nucleo1Ejercicio.gestionAcademica.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
