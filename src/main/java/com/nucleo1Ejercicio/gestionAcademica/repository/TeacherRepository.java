package com.nucleo1Ejercicio.gestionAcademica.repository;

import com.nucleo1Ejercicio.gestionAcademica.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}