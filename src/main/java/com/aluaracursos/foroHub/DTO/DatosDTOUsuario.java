package com.aluaracursos.foroHub.DTO;

public record DatosDTOUsuario(String nombre,
                              String email) {

    public DatosDTOUsuario(Usuario autor) {
        this(autor.getNombre(), autor.getEmail());
    }

}
