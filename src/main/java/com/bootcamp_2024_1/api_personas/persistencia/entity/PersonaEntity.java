package com.bootcamp_2024_1.api_personas.persistencia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;                // <-- Este paquete suele contener las clases que representan las tablas de la base de datos.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Marca la clase como una entidad JPA (Java Persistence API). Esto indica que esta clase se mapeará a una tabla en la base de datos.

@Data   /*
        Es una anotación de Lombok que combina varias funcionalidades:
        @Getter y @Setter para todos los campos.
        @ToString, @EqualsAndHashCode, y @RequiredArgsConstructor.
         */

@NoArgsConstructor //Genera un constructor sin argumentos, útil para ciertas operaciones de JPA como la creación de instancias reflejadas.
@AllArgsConstructor //Genera un constructor que acepta un argumento para cada campo en la clase.
public class PersonaEntity {

    @Id //Marca el campo id como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor de id se generará automáticamente por la base de datos cuando se inserte un nuevo registro.
    private Long id; //almacena el identificador único de cada persona

    private String nombre; //almacena el nombre
    private String apellido; //almacena el apellido

}

/*
PersonaEntity es una clase que representa la estructura de la tabla en la base de datos.
Cada instancia de PersonaEntity se corresponde con un registro en la tabla "Persona".
 */
