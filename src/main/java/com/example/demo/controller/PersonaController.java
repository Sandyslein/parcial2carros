package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // 🟢 Crear persona
    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.guardar(persona);
    }

    // 🔵 Obtener todas las personas
    @GetMapping
    public List<Persona> obtenerTodas() {
        return personaService.obtenerTodas();
    }

    // 🟡 Obtener persona por ID
    @GetMapping("/{id}")
    public Optional<Persona> obtenerPorId(@PathVariable Long id) {
        return personaService.obtenerPorId(id);
    }

    // 🟠 Actualizar persona
    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.actualizarPersona(id, persona);
    }

    // 🔴 Eliminar persona
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }
}
