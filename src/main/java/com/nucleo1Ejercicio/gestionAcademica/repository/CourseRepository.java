package com.nucleo1Ejercicio.gestionAcademica.repository;

import com.nucleo1Ejercicio.gestionAcademica.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}