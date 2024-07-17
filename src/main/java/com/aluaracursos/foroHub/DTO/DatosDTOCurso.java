package com.aluaracursos.foroHub.DTO;

import com.aluaracursos.foroHub.modelo.curso.Categoria;
import com.aluaracursos.foroHub.modelo.curso.Curso;

public record DatosDTOCurso(String nombre,
                            Categoria categoria) {

    public DatosDTOCurso(Curso curso) {
        this(curso.getNombre(), curso.getCategoria());
    }

}
