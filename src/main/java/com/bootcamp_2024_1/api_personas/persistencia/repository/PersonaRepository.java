package com.bootcamp_2024_1.api_personas.persistencia.repository;

import com.bootcamp_2024_1.api_personas.persistencia.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository; //La interfaz que provee métodos para realizar operaciones básicas de CRUD y otras funcionalidades avanzadas sobre la entidad.
import org.springframework.stereotype.Repository;

@Repository //Una anotación que marca esta interfaz como un componente de Spring que interactúa con la base de datos.
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}

/*
PersonaRepository es el punto de contacto entre la aplicación y la base de datos.
Proporciona métodos para acceder y manipular datos de la tabla correspondiente a
PersonaEntity sin que se tenga que escribir consultas SQL manualmente.
 */