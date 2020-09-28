package br.com.meuponto.application.customers.handlers;

import br.com.meuponto.application.customers.commands.CustomerCreateCommand;
import br.com.meuponto.domain.features.customers.Customer;
import br.com.meuponto.domain.features.exceptions.ExceptionCnpjInUse;
import br.com.meuponto.infrastructure.repositories.customers.CustomerRepository;
import io.jkratz.mediator.core.CommandHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreateCommandHandler implements CommandHandler<CustomerCreateCommand> {
    private  final CustomerRepository customerRepository;
    private  final ModelMapper modelMapper;

    public CustomerCreateCommandHandler(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public void handle(CustomerCreateCommand customerCreateCommand) {
        var customer = modelMapper.map(customerCreateCommand, Customer.class);
        if (customerRepository.existsByCnpj(customer.getCnpj()))
            throw new ExceptionCnpjInUse();
        customerRepository.save(customer);
    }
}
