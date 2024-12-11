package it.objectmethod.specification.controllers;

import it.objectmethod.specification.entities.Persona;
import it.objectmethod.specification.filters.PersonaParams;
import it.objectmethod.specification.repositories.PersonaRepository;
import it.objectmethod.specification.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("/all")
    public ResponseEntity<List<Persona>> getAll(@RequestParam Optional<String> gender) {
        List<Persona> personas = personaService.fetchPersons(gender);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable long id) {
        Optional<Persona> persona = Optional.ofNullable(personaService.findById(id));
        return new ResponseEntity<>(persona.get(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Persona> getPersonaByName(@PathVariable String name) {
        Optional<Persona> persona = Optional.ofNullable(personaService.findByName(name));
        return ResponseEntity.ok(persona.get());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Persona> getPersonaByEmail(@PathVariable String email) {
        Optional<Persona> persona = Optional.ofNullable(personaService.findByEmail(email));
        return ResponseEntity.ok(persona.get());
    }

    @GetMapping("/spec")
    public ResponseEntity<List<Persona>> getPersonaBySpec(final PersonaParams personaParams) {
        List<Persona> personas = personaService.specification(personaParams);
        return ResponseEntity.ok(personas);
    }

}
