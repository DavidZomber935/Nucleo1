package com.nucleo1Ejercicio.gestionAcademica.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Long classroomId;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}