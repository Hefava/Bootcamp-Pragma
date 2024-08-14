package com.bootcamp_2024_1.api_personas.dto; //dto significa Data Transfer Object

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/* Imports (lombok):
@Getter, @Setter, @NoArgsConstructor, y @AllArgsConstructor son anotaciones de Lombok,
una librería que ayuda a reducir el código boilerplate (es decir, el código repetitivo
que suele ser necesario para tareas simples).
 */

@Getter //Genera automáticamente los métodos getter para todos los campos de la clase. Un getter es un metodo público que devuelve el valor de una propiedad privada.
@Setter //Genera automáticamente los métodos setter para todos los campos de la clase. Un setter es un metodo público que permite establecer el valor de una propiedad privada.
@NoArgsConstructor //Genera un constructor sin argumentos. Esto permite crear una instancia de PersonaDto sin necesidad de proporcionar valores iniciales
@AllArgsConstructor // Genera un constructor que acepta un argumento por cada campo en la clase.
public class PersonaDto {
    private Long id; //Es un campo privado que almacena el identificador único de la persona.
    private String nombre; //Es un campo privado que almacena el nombre de la persona.
    private String apellido; // Es un campo privado que almacena el apellido de la persona.
}

/* PersonaDto es un Data Transfer Object (DTO)
En lugar de usar directamente las entidades de la base de datos, que podrían incluir mucha
más información de la necesaria o estar muy acopladas a la estructura de la base de datos,
se utilizan DTOs para enviar solo la información relevante.
 */