package br.com.meuponto.application.collaborators.commands;

import io.jkratz.mediator.core.Command;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CollaboratorDeleteCommand implements Command {
    private Integer collaboratorId;
}
