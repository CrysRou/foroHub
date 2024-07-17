package com.aluaracursos.foroHub.repository;

import com.aluaracursos.foroHub.modelo.respuesta.Respuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    Page<Respuesta> findByActivoTrue(Pageable page);
    Optional<Respuesta> findByIdAndActivoTrue(long id);
}