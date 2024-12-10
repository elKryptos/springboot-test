package it.objectmethod.specification.filters;

import it.objectmethod.specification.entities.Persona;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaParams {
    private List<Long> ids;
    private String name;
    private String email;

    public Specification<Persona> getSpecification() {
        return Specification.<Persona>where(null)
                .and(equalsIdSpecification(ids))
                .and(equalsNameSpecification(name))
                .and(equalsEmailSpecification(email));
    }

    private static Specification<Persona> equalsIdSpecification(List<Long> ids) {
        if(ids == null) return null;
        return (((root, query, criteriaBuilder) ->
                criteriaBuilder.in(root.get("id")).value(ids)));
    }

    private Specification<Persona> equalsNameSpecification(String name) {
        if(name == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name.toLowerCase());
    }

    private Specification<Persona> equalsEmailSpecification(String email) {
        if(email == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("email"), email.toLowerCase());
    }

}
