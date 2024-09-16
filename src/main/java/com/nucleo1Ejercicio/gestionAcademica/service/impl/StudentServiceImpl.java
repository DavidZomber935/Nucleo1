package com.nucleo1Ejercicio.gestionAcademica.service.impl;

import com.nucleo1Ejercicio.gestionAcademica.model.Student;
import com.nucleo1Ejercicio.gestionAcademica.repository.StudentRepository;
import com.nucleo1Ejercicio.gestionAcademica.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setStudentId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}