package com.aluaracursos.foroHub.service;


import com.aluaracursos.foroHub.DTO.DatosDTORespuesta;
import com.aluaracursos.foroHub.modelo.respuesta.DatosActualizarRespuesta;
import com.aluaracursos.foroHub.modelo.respuesta.DatosRespuesta;
import com.aluaracursos.foroHub.modelo.respuesta.Respuesta;
import com.aluaracursos.foroHub.repository.RespuestaRepository;
import com.aluaracursos.foroHub.repository.TopicoRepository;
import com.aluaracursos.foroHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ServiceRespuesta {
    @Autowired
    private RespuestaRepository repository;
    @Autowired
    private UsuarioRepository userR;
    @Autowired
    private TopicoRepository topicR;

    public Page<DatosDTORespuesta> getAllRespuestas(Pageable page) {
        var respuesta = repository.findByActivoTrue(page);
        return respuesta.map(r -> new DatosDTORespuesta(r));
    }

    public Respuesta registrarRespuesta(@Valid DatosRespuesta datoRespuesta) throws NoExiste {
        var user = userR.findByIdAndActivoTrue(datoRespuesta.autor());
        if(!user.isPresent()){
            throw new NoExiste("Usuario no existe");
        }
        var topico = topicR.findByIdAndStatusTrue(datoRespuesta.topico());
        if(!topico.isPresent()){
            throw new NoExiste("Ese topico no existe");
        }
        var resp = new Respuesta(datoRespuesta,topico.get(),user.get());
        repository.save(resp);
        return resp;
    }

    public DatosDTORespuesta getRespuestaById(Long id) throws NoExiste {
        var resp = existe(id);
        return new DatosDTORespuesta(resp);
    }

    public DatosDTORespuesta updateRespuesta(Long id, DatosActualizarRespuesta datosRespuesta) throws NoExiste {
        var resp = existe(id);
        resp.actualizarRespuesta(datosRespuesta);
        return new DatosDTORespuesta(resp);
    }

    public void deletarRespuesta(Long id) throws NoExiste {
        var resp = existe(id);
        resp.desativar();
    }

    private Respuesta existe(Long id) throws NoExiste{
        var resp = repository.findByIdAndActivoTrue(id);
        if(!resp.isPresent()){
            throw new NoExiste("No existe esa respuesta");
        }
        return resp.get();
    }


}

