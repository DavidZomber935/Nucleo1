package com.nucleo1Ejercicio.gestionAcademica.service.impl;

import com.nucleo1Ejercicio.gestionAcademica.model.Classroom;
import com.nucleo1Ejercicio.gestionAcademica.repository.ClassroomRepository;
import com.nucleo1Ejercicio.gestionAcademica.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        Optional<Classroom> classroom = classroomRepository.findById(id);
        return classroom.orElse(null);
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom updateClassroom(Long id, Classroom classroom) {
        if (classroomRepository.existsById(id)) {
            classroom.setClassroomId(id);
            return classroomRepository.save(classroom);
        }
        return null;
    }

    @Override
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}