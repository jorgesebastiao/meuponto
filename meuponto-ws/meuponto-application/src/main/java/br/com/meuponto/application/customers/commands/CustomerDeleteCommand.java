package br.com.meuponto.application.customers.commands;

import io.jkratz.mediator.core.Command;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerDeleteCommand implements Command {
    private Integer customerId;
}
