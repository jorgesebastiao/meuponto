package br.com.meuponto.infrastructure.repositories.collaborators;

import br.com.meuponto.domain.features.collaborators.Collaborator;
import br.com.meuponto.infrastructure.repositories.base.RepositoryBase;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends RepositoryBase<Collaborator, Integer> {

}
