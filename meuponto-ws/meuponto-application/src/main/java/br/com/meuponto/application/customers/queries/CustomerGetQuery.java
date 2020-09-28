package br.com.meuponto.application.customers.queries;

import br.com.meuponto.domain.features.customers.Customer;
import io.jkratz.mediator.core.Request;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerGetQuery implements Request<Customer> {
    private Integer customerId;
}
