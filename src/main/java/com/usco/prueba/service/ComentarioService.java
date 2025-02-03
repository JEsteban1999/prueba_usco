package com.usco.prueba.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.prueba.entity.Caso;
import com.usco.prueba.entity.Comentario;
import com.usco.prueba.entity.Usuario;
import com.usco.prueba.repository.CasoRepository;
import com.usco.prueba.repository.ComentarioRepository;
import com.usco.prueba.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final CasoRepository casoRepository;

    public Comentario agregarComentario(Long usuarioId, Long casoId, String contenido) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Caso caso = casoRepository.findById(casoId)
            .orElseThrow(() -> new RuntimeException("Caso no encontrado"));

        Comentario comentario = new Comentario();
        comentario.setUsuario(usuario);
        comentario.setCaso(caso);
        comentario.setContenido(contenido);
        comentario.setFecha(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }
}
