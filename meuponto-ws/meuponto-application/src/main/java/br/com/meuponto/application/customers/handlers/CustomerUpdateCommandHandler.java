package br.com.meuponto.application.customers.handlers;

import br.com.meuponto.application.customers.commands.CustomerUpdateCommand;
import br.com.meuponto.infrastructure.repositories.customers.CustomerRepository;
import io.jkratz.mediator.core.CommandHandler;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CustomerUpdateCommandHandler  implements CommandHandler<CustomerUpdateCommand> {
    private  final CustomerRepository customerRepository;
    private  final ModelMapper modelMapper;

    public CustomerUpdateCommandHandler(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public void handle(CustomerUpdateCommand customerUpdateCommand) {
        var customerDatabase = customerRepository.findById(customerUpdateCommand.getId())
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        modelMapper.map(customerUpdateCommand, customerDatabase);

        customerRepository.save(customerDatabase);
    }
}
