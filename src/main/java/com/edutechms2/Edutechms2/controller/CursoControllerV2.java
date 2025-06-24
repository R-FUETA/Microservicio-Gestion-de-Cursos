package com.edutechms2.Edutechms2.controller;

import com.edutechms2.Edutechms2.model.Curso;
import com.edutechms2.Edutechms2.service.CursoService;
import com.edutechms2.Edutechms2.hateoas.CursoModelAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/cursos")
@Tag(name = "Cursos", description = "Gestion de Cursos")
public class CursoControllerV2 {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoModelAssembler assembler;

    @Operation(summary = "Crea curso", description = "Permite Crear Cursos")
    @PostMapping
    public EntityModel<Curso> crear(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return assembler.toModel(nuevoCurso);
    }

    @Operation(summary = "Obtener Curso ID", description = "Permite Obtener cursos por ID")
    @GetMapping("id/{id}")
    public EntityModel<Curso> obtener(@PathVariable Long id) {
        Curso curso = cursoService.obtenerPorId(id);
        return assembler.toModel(curso);
    }

    @Operation(summary = "Actualiza Curso", description = "Permite Actualizar Cursos")
    @PutMapping("id/{id}")
    public EntityModel<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        Curso actualizado = cursoService.actualizarCurso(id, curso);
        return assembler.toModel(actualizado);
    }

    @Operation(summary = "Elimina Curso", description = "Permite Eliminar Cursos")
    @DeleteMapping("id/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }

    @Operation(summary = "Todos los Cursos", description = "Permite Visualizar Todos los cursos")
    @GetMapping
    public CollectionModel<EntityModel<Curso>> listar() {
        List<EntityModel<Curso>> cursos = cursoService.listarCursos()
            .stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(
            cursos,
            linkTo(methodOn(CursoControllerV2.class).listar()).withSelfRel()
        );
    }
}