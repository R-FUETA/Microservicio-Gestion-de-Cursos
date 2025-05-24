package com.edutechms2.Edutechms2.service;

import com.edutechms2.Edutechms2.model.Curso;
import com.edutechms2.Edutechms2.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    //Crea un nuevo curso en la base de datos.
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    //Actualiza los datos de un curso existente.
    public Curso actualizarCurso(Long id, Curso curso) {
        Curso existente = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        existente.setNombre(curso.getNombre());
        existente.setDescripcion(curso.getDescripcion());
        existente.setDuracionHoras(curso.getDuracionHoras());
        existente.setActivo(curso.isActivo());
        existente.setNivel(curso.getNivel());
        existente.setCategoria(curso.getCategoria());
        return cursoRepository.save(existente);
    }

    //Elimina un curso por su ID.
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    //Obtiene un curso por su ID.
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).get();
    }

    //Lista todos los cursos registrados.
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
