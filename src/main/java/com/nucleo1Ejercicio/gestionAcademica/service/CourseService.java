package com.nucleo1Ejercicio.gestionAcademica.service;

import com.nucleo1Ejercicio.gestionAcademica.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}