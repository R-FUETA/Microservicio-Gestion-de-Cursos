package com.edutechms2.Edutechms2.controller;


import com.edutechms2.Edutechms2.model.Curso;
import com.edutechms2.Edutechms2.service.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@Tag(name = "Cursos", description = ("Gestion de Cursos"))
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //Crea un nuevo curso.
    @Operation(summary = "Crea curso", description = "Permite Crear Cursos")
    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    //Obtiene un curso por su ID.
    @Operation(summary = "Obtener Curso ID", description = "Permite Obtener cursos por ID")
    @GetMapping("id/{id}")
    public Curso obtener(@PathVariable Long id) {
        return cursoService.obtenerPorId(id);
    }

    //Actualiza un curso existente.
    @Operation(summary = "Actualiza Curso", description = "Permite Actualizar Cursos")
    @PutMapping("id/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    //Elimina un curso por su ID.
    @Operation(summary = "Elimina Curso", description = "Permite Eliminar Cursos")
    @DeleteMapping("id/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }

    //Lista todos los cursos.
    @Operation(summary = "Todos los Cursos", description = "Permite Visualizar Todos los cursos")
    @GetMapping
    public List<Curso> listar() {
        return cursoService.listarCursos();
    }
}
