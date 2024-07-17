package com.aluaracursos.foroHub.modelo.respuesta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(
        @NotNull @NotBlank String mensaje,
        @NotNull @Valid long topico,
        @NotNull @FutureOrPresent LocalDateTime fecha,
        @NotNull @Valid long autor,
        @NotBlank @NotNull String solucion) {

}
