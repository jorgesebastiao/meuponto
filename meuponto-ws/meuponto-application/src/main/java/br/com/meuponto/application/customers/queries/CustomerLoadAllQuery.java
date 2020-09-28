package br.com.meuponto.application.customers.queries;

import br.com.meuponto.domain.features.customers.Customer;
import io.jkratz.mediator.core.Request;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
public class CustomerLoadAllQuery implements Request<Page<Customer>> {
    private String filter;
    private Pageable pageable;
}
