package com.aluaracursos.foroHub.repository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);
    @Query("""
            SELECT u FROM Usuario u
            WHERE u.email = :email
            """)
    Optional<Usuario> cojerUsuarioPorEmail(String email);
    Optional<Usuario> findByIdAndActivoTrue(long id);
}
