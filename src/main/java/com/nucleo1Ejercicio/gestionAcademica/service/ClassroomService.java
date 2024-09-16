package com.nucleo1Ejercicio.gestionAcademica.service;

import com.nucleo1Ejercicio.gestionAcademica.model.Classroom;
import java.util.List;

public interface ClassroomService {
    List<Classroom> getAllClassrooms();
    Classroom getClassroomById(Long id);
    Classroom createClassroom(Classroom classroom);
    Classroom updateClassroom(Long id, Classroom classroom);
    void deleteClassroom(Long id);
}
