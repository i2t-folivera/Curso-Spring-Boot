package com.ejemplo.Cursos.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long profesorId;
}
