package com.example.demo.integration;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonaIntegrationTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testGuardarPersona() {
        Persona persona = new Persona();
        persona.setNombre("Carlos");
        persona.setEdad(33);

        Persona guardada = personaRepository.save(persona);

        assertNotNull(guardada.getId());
        assertEquals("Carlos", guardada.getNombre());
    }
}
