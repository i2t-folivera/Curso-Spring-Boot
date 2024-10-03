package com.ejemplo.Cursos.DTOs;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class InscripcionDTO {
    private Long id;
    private Long alumnoId;
    private Long cursoId;
    private LocalDate fechaInscripcion;
}
