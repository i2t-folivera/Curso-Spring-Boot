package com.ejemplo.Cursos.DTOs;

import lombok.Data;
import java.util.List;

@Data
public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private List<Long> cursoIds; // Asegúrate de que esta línea esté presente
}
