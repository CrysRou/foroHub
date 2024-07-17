package com.aluaracursos.foroHub.repository;

import com.aluaracursos.foroHub.modelo.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Page<Topico> findByStatusTrue(Pageable page);
    Optional<Topico> findByIdAndStatusTrue(long id);
}
