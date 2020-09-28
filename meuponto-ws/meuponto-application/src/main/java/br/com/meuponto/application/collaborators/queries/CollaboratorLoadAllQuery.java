package br.com.meuponto.application.collaborators.queries;

import br.com.meuponto.domain.features.collaborators.Collaborator;
import io.jkratz.mediator.core.Request;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
public class CollaboratorLoadAllQuery implements Request<Page<Collaborator>> {
    private String filter;
    private Pageable pageable;
}
