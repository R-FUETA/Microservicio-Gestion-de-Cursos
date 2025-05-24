CREATE DATABASE cursos_db;

USE cursos_db;

INSERT INTO cursos (nombre, descripcion, duracion_horas, activo, nivel, categoria) VALUES
('Java Básico', 'Curso de introducción a la programación en Java.', 40, true, 'Principiante', 'Tecnología'),
('Fundamentos de Marketing', 'Conceptos esenciales de marketing digital y tradicional.', 30, true, 'Intermedio', 'Negocios'),
('Bases de Datos con MySQL', 'Aprende a diseñar y consultar bases de datos relacionales.', 50, true, 'Intermedio', 'Tecnología'),
('Introducción a Python', 'Curso práctico para aprender los fundamentos de Python.', 35, true, 'Principiante', 'Tecnología'),
('Liderazgo Estratégico', 'Desarrolla habilidades de liderazgo en entornos empresariales.', 20, false, 'Avanzado', 'Gestión');
