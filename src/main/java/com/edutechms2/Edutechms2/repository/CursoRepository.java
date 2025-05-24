package com.edutechms2.Edutechms2.repository;

import com.edutechms2.Edutechms2.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio JPA para la entidad Curso.
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
