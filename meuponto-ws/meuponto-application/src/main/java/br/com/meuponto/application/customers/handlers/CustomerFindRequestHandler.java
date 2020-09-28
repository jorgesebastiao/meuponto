package br.com.meuponto.application.customers.handlers;

import br.com.meuponto.application.customers.queries.CustomerGetQuery;
import br.com.meuponto.domain.features.customers.Customer;
import br.com.meuponto.infrastructure.repositories.customers.CustomerRepository;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CustomerFindRequestHandler   implements RequestHandler<CustomerGetQuery, Customer> {
    private final CustomerRepository customerRepository;

    public CustomerFindRequestHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer handle(CustomerGetQuery customerGetQuery) {
        return customerRepository.findById(customerGetQuery.getCustomerId())
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
