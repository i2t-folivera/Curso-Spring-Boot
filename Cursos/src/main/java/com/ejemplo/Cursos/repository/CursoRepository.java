package com.ejemplo.Cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.Cursos.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}