package com.usco.prueba.dto;

import lombok.Data;

@Data   
public class CasoRequestDTO {

    private Long usuarioId;
    private String tipo;
    private String descripcion;
}
