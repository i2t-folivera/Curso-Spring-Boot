package com.ejemplo.Cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.Cursos.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
