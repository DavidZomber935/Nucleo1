package com.nucleo1Ejercicio.gestionAcademica.repository;

import com.nucleo1Ejercicio.gestionAcademica.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}