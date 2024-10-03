package com.ejemplo.Cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.Cursos.models.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
