package com.nucleo1Ejercicio.gestionAcademica.service;

import com.nucleo1Ejercicio.gestionAcademica.model.Teacher;
import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
}