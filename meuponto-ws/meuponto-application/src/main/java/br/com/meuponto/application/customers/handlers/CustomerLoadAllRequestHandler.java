package br.com.meuponto.application.customers.handlers;

import br.com.meuponto.application.customers.queries.CustomerLoadAllQuery;
import br.com.meuponto.domain.features.customers.Customer;
import br.com.meuponto.infrastructure.repositories.customers.CustomerRepository;
import br.com.meuponto.infrastructure.repositories.customers.CustomerSpecification;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CustomerLoadAllRequestHandler  implements RequestHandler<CustomerLoadAllQuery, Page<Customer>> {
    private final CustomerRepository customerRepository;

    public CustomerLoadAllRequestHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> handle(CustomerLoadAllQuery customerLoadAllQuery) {
        return customerRepository.findAll(CustomerSpecification.filter(customerLoadAllQuery.getFilter()), customerLoadAllQuery.getPageable());
    }
}
