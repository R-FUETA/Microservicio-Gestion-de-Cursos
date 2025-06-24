package com.edutechms2.Edutechms2.hateoas;

import com.edutechms2.Edutechms2.controller.CursoControllerV2;
import com.edutechms2.Edutechms2.model.Curso;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CursoModelAssembler implements RepresentationModelAssembler<Curso, EntityModel<Curso>> {

    @Override
    public EntityModel<Curso> toModel(Curso curso) {
        return EntityModel.of(
            curso,
            linkTo(methodOn(CursoControllerV2.class).obtener(curso.getId())).withSelfRel(),
            linkTo(methodOn(CursoControllerV2.class).listar()).withRel("cursos"),
            linkTo(methodOn(CursoControllerV2.class).actualizar(curso.getId(), curso)).withRel("actualizar"),
            linkTo(CursoControllerV2.class)
            .slash("id")
            .slash(curso.getId())
            .withRel("eliminar")

        );
    }
}