package com.aluaracursos.foroHub.DTO;

import com.aluaracursos.foroHub.modelo.respuesta.Respuesta;

import java.time.LocalDateTime;

public record DatosDTORespuesta(
        String mensaje,
        //DatosDTOTopico topico,
        LocalDateTime fecha,
        DatosDTOUsuario autor,
        String solucion) {

    public DatosDTORespuesta(Respuesta r) {
        this(r.getMensaje()/*, new DatosDTOTopico(r.getTopico())*/, r.getFecha(), new DatosDTOUsuario(r.getAutor()),
                r.getSolucion());
    }

}
