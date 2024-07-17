package com.aluaracursos.foroHub.modelo.topico;

import com.aluaracursos.foroHub.modelo.curso.DatosActualizarCurso;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        DatosActualizarCurso curso
) {

}
