package br.com.meuponto.application.collaborators.handlers;

import br.com.meuponto.application.collaborators.queries.CollaboratorLoadAllQuery;
import br.com.meuponto.domain.features.collaborators.Collaborator;
import br.com.meuponto.infrastructure.repositories.collaborators.CollaboratorRepository;
import br.com.meuponto.infrastructure.repositories.collaborators.CollaboratorSpecification;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorLoadAllRequestHandler  implements RequestHandler<CollaboratorLoadAllQuery, Page<Collaborator>> {
    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorLoadAllRequestHandler(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    public Page<Collaborator> handle(CollaboratorLoadAllQuery collaboratorLoadAllQuery) {
        return collaboratorRepository.findAll(CollaboratorSpecification.filter(collaboratorLoadAllQuery.getFilter()), collaboratorLoadAllQuery.getPageable());
    }
}
