package br.com.meuponto.application.customers.handlers;

import br.com.meuponto.application.customers.commands.CustomerDeleteCommand;
import br.com.meuponto.infrastructure.repositories.customers.CustomerRepository;
import io.jkratz.mediator.core.CommandHandler;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CustomerDeleteCommandHandler implements CommandHandler<CustomerDeleteCommand> {
    private  final CustomerRepository customerRepository;

    public CustomerDeleteCommandHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void handle(CustomerDeleteCommand customerDeleteCommand) {
        var customer = customerRepository.findById(customerDeleteCommand.getCustomerId())
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        customerRepository.delete(customer);
    }
}
