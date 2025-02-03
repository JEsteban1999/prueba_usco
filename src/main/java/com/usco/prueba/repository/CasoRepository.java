package com.usco.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.prueba.entity.Caso;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
    List<Caso> findByEstudianteAsignado(String estudiante);
}
