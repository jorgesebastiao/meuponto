package br.com.meuponto.infrastructure.repositories.collaborators;

import br.com.meuponto.domain.features.collaborators.Collaborator;
import org.springframework.data.jpa.domain.Specification;

public class CollaboratorSpecification {
    public static Specification<Collaborator> filter(String filter) {
        return (root, query, builder) -> {
            var nameFilter = builder.like(root.get("name"), "%" + filter + "%");
            var cpfFilter = builder.like(root.get("cpf"), "%" + filter + "%");
            return builder.or(nameFilter, cpfFilter);
        };
    }
}
