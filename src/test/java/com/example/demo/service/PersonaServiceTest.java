package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonaServiceTest {

    private PersonaRepository personaRepository;
    private PersonaService personaService;

    @BeforeEach
    void setUp() {
        personaRepository = mock(PersonaRepository.class);
        personaService = new PersonaService(personaRepository);
    }

    @Test
    void testGuardar() {
        Persona persona = new Persona();
        persona.setNombre("Sandy");
        persona.setEdad(28);

        when(personaRepository.save(persona)).thenReturn(persona);

        Persona resultado = personaService.guardar(persona);

        assertEquals("Sandy", resultado.getNombre());
        verify(personaRepository).save(persona);
    }

    @Test
    void testObtenerTodas() {
        List<Persona> lista = Arrays.asList(
                new Persona(1L, "Ana", 25),
                new Persona(2L, "Luis", 30)
        );

        when(personaRepository.findAll()).thenReturn(lista);

        List<Persona> resultado = personaService.obtenerTodas();
        assertEquals(2, resultado.size());
    }

    @Test
    void testObtenerPorId() {
        Persona persona = new Persona(); // usa setters para evitar constructor vacío
        persona.setId(1L);
        persona.setNombre("Ana");
        persona.setEdad(25);

        when(personaRepository.findById(1L)).thenReturn(Optional.of(persona));

        Optional<Persona> resultado = personaService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Ana", resultado.get().getNombre()); // ✅ ahora sí debe pasar
    }

}
