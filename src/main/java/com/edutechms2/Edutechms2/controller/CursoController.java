package com.edutechms2.Edutechms2.controller;


import com.edutechms2.Edutechms2.model.Curso;
import com.edutechms2.Edutechms2.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //Crea un nuevo curso.
    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    //Obtiene un curso por su ID.
    @GetMapping("id/{id}")
    public Curso obtener(@PathVariable Long id) {
        return cursoService.obtenerPorId(id);
    }

    //Actualiza un curso existente.
    @PutMapping("id/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    //Elimina un curso por su ID.
    @DeleteMapping("id/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }

    //Lista todos los cursos.
    @GetMapping
    public List<Curso> listar() {
        return cursoService.listarCursos();
    }
}
