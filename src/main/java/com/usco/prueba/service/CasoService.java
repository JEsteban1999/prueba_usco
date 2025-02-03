package com.usco.prueba.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.usco.prueba.entity.Caso;
import com.usco.prueba.entity.Usuario;
import com.usco.prueba.repository.CasoRepository;
import com.usco.prueba.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CasoService {

    private final CasoRepository casoRepository;
    private final UsuarioRepository usuarioRepository;

    // 1. Registrar una solicitud de caso
    public Caso registrarCaso(Long usuarioId, String tipo, String descripcion) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));
        
        Caso caso = new Caso();
        caso.setUsuario(usuario);
        caso.setTipo(tipo);
        caso.setDescripcion(descripcion);
        caso.setEstado("Abierto");
        caso.setFechaCreacion(LocalDateTime.now());

        return casoRepository.save(caso);
    }

    // 2. Asignar un caso a un estudiante
    public Caso asignarCaso(Long casoId, String estudiante) {
        Caso caso = casoRepository.findById(casoId)
            .orElseThrow(() -> new RuntimeException("No se encontró el caso"));
        
        caso.setEstudianteAsignado(estudiante);
        return casoRepository.save(caso);
    }

    // 3. Actualizar el estado de un caso
    public Caso actualizarEstado(Long casoId, String nuevoEstado) {
        Caso caso = casoRepository.findById(casoId)
            .orElseThrow(() -> new RuntimeException("No se encontró el caso"));
        
        caso.setEstado(nuevoEstado);
        return casoRepository.save(caso);
    }

    // 4. Consultar los casos asignados a un estudiante
    public List<Caso> obtenerCasosPorEstudiante(String estudiante) {
        return casoRepository.findByEstudianteAsignado(estudiante);
    }
}
