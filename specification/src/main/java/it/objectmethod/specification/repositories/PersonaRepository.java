package it.objectmethod.specification.repositories;

import it.objectmethod.specification.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {

    Persona findByName(String nome);

    Persona findByEmail(String email);

    Persona findByNameAndEmailOrderByIdDesc(String name, String email);


    List<Persona> findByGender(String gender);
}
