package it.objectmethod.specification.services;

import it.objectmethod.specification.entities.Persona;
import it.objectmethod.specification.filters.PersonaParams;
import it.objectmethod.specification.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona findById(Long id) {
        return personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
    }

    public Persona findByName(String name) {
        return personaRepository.findByName(name);
    }

    public Persona findByEmail(String email) {
        return personaRepository.findByEmail(email);
    }

    public List<Persona> specification(PersonaParams personaParams) {
        List<Persona> personas = personaRepository.findAll(personaParams.getSpecification());
        return personas;

    }
}
