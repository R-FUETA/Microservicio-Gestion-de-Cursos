package com.edutechms2.Edutechms2.model;

import jakarta.persistence.*;
import lombok.*;

//Entidad JPA que representa un curso dentro del sistema EduTech.
@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del curso
    @Column(nullable = false)
    private String nombre;

    // Descripción breve del contenido del curso
    @Column(length = 1000)
    private String descripcion;

    // Duración en horas
    @Column(nullable = false)
    private int duracionHoras;

    // Indica si el curso está disponible para estudiantes
    private boolean activo;

    // Nivel del curso (Principiante, Intermedio, Avanzado)
    private String nivel;

    // Categoría
    private String categoria;
}