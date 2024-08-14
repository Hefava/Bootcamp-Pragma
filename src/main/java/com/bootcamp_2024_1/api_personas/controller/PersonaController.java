package com.bootcamp_2024_1.api_personas.controller;

import com.bootcamp_2024_1.api_personas.dto.PersonaDto;
import com.bootcamp_2024_1.api_personas.mapper.PersonaMapper;
import com.bootcamp_2024_1.api_personas.persistencia.entity.PersonaEntity;
import com.bootcamp_2024_1.api_personas.persistencia.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //Indica que esta clase es un controlador en Spring que manejará solicitudes HTTP y devolverá respuestas en formato JSON.
@RequestMapping("/personas") //Define el endpoint base para todas las rutas dentro de esta clase. Todos los métodos aquí manejarán solicitudes que comiencen con /personas.
@RequiredArgsConstructor //Es una anotación de Lombok que genera un constructor con todos los atributos final de la clase. Esto se utiliza para inyectar dependencias.
public class PersonaController {

    private final PersonaRepository personaRepository; //Es una inyección de dependencias que permite acceder al repositorio de Persona, que maneja la persistencia de datos en la base de datos.
    private final PersonaMapper personaMapper; //También es una inyección de dependencias, pero en este caso es un mapper que transforma entre objetos de tipo PersonaDto y PersonaEntity.

    @GetMapping // Este metodo maneja las solicitudes HTTP GET a /personas.
    private List<PersonaDto> obtenerPersona() {
        return personaRepository
                .findAll() //Obtiene todas las entidades PersonaEntity desde la base de datos.
                .stream() // Convierte la lista en un flujo (stream) para procesarla de manera funcional.
                /* STREAM VS CICLOS
                 Ciclos while/for (Imperativo): Tú defines cómo se hace la iteración y qué sucede en cada paso.
                 Stream (Declarativo): Tú defines qué quieres hacer (como mapear, filtrar, recolectar) y Java se encarga de cómo se hace internamente.
                 */
                .map(personaEntity -> personaMapper.personaDtoToPersonaEntity(personaEntity)) //Convierte cada PersonaEntity a PersonaDto usando el PersonaMapper.
                .collect(Collectors.toList()); //Recolecta los objetos PersonaDto en una lista y la devuelve como respuesta.
    }


    @PostMapping // Este metodo maneja solicitudes HTTP POST a /personas.
    private PersonaDto crearPersona(@RequestBody PersonaDto persona) { // @RequestBody Indica que el parámetro persona se recibe en el cuerpo de la solicitud HTTP.
        PersonaEntity personaEntity = this.personaRepository.save( // desde this. -> Guarda la entidad PersonaEntity en la base de datos y devuelve la entidad guardada, la cual puede incluir valores generados (como un ID).
                personaMapper.personaEntityToPersonaDto(persona) //Convierte el objeto PersonaDto recibido en la solicitud a una entidad PersonaEntity.
        );
        return personaMapper.personaDtoToPersonaEntity(personaEntity); //Convierte la entidad guardada (que puede tener nuevos valores como un ID) de vuelta a un PersonaDto para devolverlo como respuesta.
    }

}
