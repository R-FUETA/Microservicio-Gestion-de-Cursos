package com.edutechms2.Edutechms2.config;

import com.edutechms2.Edutechms2.model.Curso;
import com.edutechms2.Edutechms2.repository.CursoRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    private final String[] niveles = {"Principiante", "Intermedio", "Avanzado"};
    private final String[] categorias = {"Programación", "Diseño", "Matemáticas", "Idiomas", "Ciencias", "Negocios"};

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        for (int i = 0; i < 20; i++) {
            Curso curso = Curso.builder()
                    .nombre(faker.educator().course())
                    .descripcion(faker.lorem().paragraph())
                    .duracionHoras(random.nextInt(80) + 10) // entre 10 y 90 horas
                    .activo(random.nextBoolean())
                    .nivel(niveles[random.nextInt(niveles.length)])
                    .categoria(categorias[random.nextInt(categorias.length)])
                    .build();

            cursoRepository.save(curso);
        }

        System.out.println("✔ Cursos de prueba generados con DataFaker.");
    }
}
