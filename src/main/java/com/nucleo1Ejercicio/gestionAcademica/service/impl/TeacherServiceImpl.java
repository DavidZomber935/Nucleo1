package com.nucleo1Ejercicio.gestionAcademica.service.impl;

import com.nucleo1Ejercicio.gestionAcademica.model.Teacher;
import com.nucleo1Ejercicio.gestionAcademica.repository.TeacherRepository;
import com.nucleo1Ejercicio.gestionAcademica.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        if (teacherRepository.existsById(id)) {
            teacher.setTeacherId(id);
            return teacherRepository.save(teacher);
        }
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
