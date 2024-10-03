package com.ejemplo.Cursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.Cursos.DTOs.AlumnoDTO;
import com.ejemplo.Cursos.models.Alumno;
import com.ejemplo.Cursos.models.Curso;
import com.ejemplo.Cursos.models.Inscripcion;
import com.ejemplo.Cursos.repository.AlumnoRepository;
import com.ejemplo.Cursos.repository.CursoRepository;
import com.ejemplo.Cursos.repository.InscripcionRepository;
import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<AlumnoDTO> getAllAlumnos() {
        return alumnoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AlumnoDTO inscribirAlumno(AlumnoDTO alumnoDTO) {
        try {
            // Crear entidad Alumno a partir del DTO
            Alumno alumno = new Alumno();
            alumno.setNombre(alumnoDTO.getNombre());
            alumno.setApellido(alumnoDTO.getApellido());

            // Validar que el curso existe antes de inscribir
            for (Long cursoId : alumnoDTO.getCursoIds()) {
                Curso curso = cursoRepository.findById(cursoId)
                        .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + cursoId));

                // Crear la inscripción
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setAlumno(alumno);
                inscripcion.setCurso(curso);
                inscripcion.setFechaInscripcion(LocalDate.now());

                // Añadir la inscripción al alumno
                alumno.getInscripciones().add(inscripcion);
            }

            // Guardar el alumno con la inscripción
            Alumno alumnoGuardado = alumnoRepository.save(alumno);

            // Convertir el alumno guardado a DTO
            return convertToDto(alumnoGuardado);

        } catch (Exception e) {
            // Manejar cualquier excepción
            throw new RuntimeException("Error al inscribir el alumno: " + e.getMessage());
        }
    }

    // Método para convertir entidad Alumno a DTO
    private AlumnoDTO convertToDto(Alumno alumno) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellido(alumno.getApellido());

        // Obtener ids de los cursos en los que el alumno está inscrito
        List<Long> cursoIds = alumno.getInscripciones().stream()
                .map(inscripcion -> inscripcion.getCurso().getId())
                .collect(Collectors.toList());

        alumnoDTO.setCursoIds(cursoIds); // Asignar los IDs de los cursos al DTO
        return alumnoDTO;
    }
}
