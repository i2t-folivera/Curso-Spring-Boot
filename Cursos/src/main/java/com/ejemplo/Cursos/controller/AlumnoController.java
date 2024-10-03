package com.ejemplo.Cursos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejemplo.Cursos.DTOs.AlumnoDTO;
import com.ejemplo.Cursos.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        List<AlumnoDTO> alumnos = alumnoService.getAllAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK); // Retorna la lista de alumnos con estado 200 OK
    }

   
    @PostMapping
    public ResponseEntity<AlumnoDTO> saveAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO createdAlumno = alumnoService.inscribirAlumno(alumnoDTO);
        return new ResponseEntity<>(createdAlumno, HttpStatus.CREATED); // Retorna el alumno creado con estado 201 CREATED
    }

}
