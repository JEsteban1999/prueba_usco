package com.usco.prueba.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usco.prueba.entity.Comentario;
import com.usco.prueba.service.ComentarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;

    // 1. Agregar comentario

    @PostMapping("/agregar")
    public ResponseEntity<Comentario> agregarComentario(@RequestParam Long usuarioId, @RequestParam Long casoId, @RequestParam String contenido) {
        Comentario comentario = comentarioService.agregarComentario(usuarioId, casoId, contenido);
        return ResponseEntity.ok(comentario);
    }
}
