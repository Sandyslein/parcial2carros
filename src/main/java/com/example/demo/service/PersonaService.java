package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();
    }

    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona actualizarPersona(Long id, Persona personaActualizada) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(personaActualizada.getNombre());
        persona.setEdad(personaActualizada.getEdad());
        return personaRepository.save(persona);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

}
