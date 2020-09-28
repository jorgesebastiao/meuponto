package br.com.meuponto.application.collaborators.queries;

import br.com.meuponto.domain.features.collaborators.Collaborator;
import io.jkratz.mediator.core.Request;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CollaboratorGetQuery implements Request<Collaborator> {
    private Integer customerId;

}
