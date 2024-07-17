package com.aluaracursos.foroHub.service;



import com.aluaracursos.foroHub.DTO.DatosDTOCurso;
import com.aluaracursos.foroHub.modelo.curso.Curso;
import com.aluaracursos.foroHub.modelo.curso.DatosActualizarCurso;
import com.aluaracursos.foroHub.modelo.curso.DatosCurso;
import com.aluaracursos.foroHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ServiceCurso {
    @Autowired
    private CursoRepository repository;

    public Page<DatosDTOCurso> getAllCursos(Pageable page) {
        var respuesta = repository.findByActivoTrue(page);
        return respuesta.map(c -> new DatosDTOCurso(c));
    }

    public Curso registrarCurso(@Valid DatosCurso datoCurso) {
        var curso = new Curso(datoCurso);
        repository.save(curso);
        return curso;
    }

    public DatosDTOCurso getCursoById(Long id) throws NoExiste {
        var curso = existe(id);
        return new DatosDTOCurso(curso);
    }

    public DatosDTOCurso updateCurso(Long id, DatosActualizarCurso datosCurso) throws NoExiste {
        var curso = existe(id);
        curso.ActualizarCurso(datosCurso);
        return new DatosDTOCurso(curso);
    }

    public void deletarCurso(Long id) throws NoExiste {
        var curso = existe(id);
        curso.desativar();
    }

    private Curso existe(Long id) throws NoExiste{
        var curso = repository.findByIdAndActivoTrue(id);
        if(!curso.isPresent()){
            throw new NoExiste("No existe el curso con id: "+id);
        }
        return curso.get();
    }









}
