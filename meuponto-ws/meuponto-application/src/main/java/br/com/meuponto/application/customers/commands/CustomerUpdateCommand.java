package br.com.meuponto.application.customers.commands;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateCommand implements Command {
    private Integer id;
    private String corporateName;
    private String tradeName;
}
