package com.ejemplo.Cursos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.Cursos.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

