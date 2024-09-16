package com.nucleo1Ejercicio.gestionAcademica.service.impl;

import com.nucleo1Ejercicio.gestionAcademica.model.Course;
import com.nucleo1Ejercicio.gestionAcademica.repository.CourseRepository;
import com.nucleo1Ejercicio.gestionAcademica.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            course.setCourseId(id);
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}