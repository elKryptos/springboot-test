package it.objectmethod.specification.services;

import it.objectmethod.specification.entities.Persona;
import it.objectmethod.specification.filters.PersonaParams;
import it.objectmethod.specification.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<Persona> fetchPersons(Optional<String> gender) {
        if (gender.isPresent()) {
            return personaRepository.findByGender(gender.get());
        } else if (gender.get().isBlank() || gender.get().isEmpty()) {
            return personaRepository.findAll();
        } else {
            return personaRepository.findAll();
        }
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
