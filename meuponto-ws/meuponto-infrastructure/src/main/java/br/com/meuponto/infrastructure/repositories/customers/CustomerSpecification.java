package br.com.meuponto.infrastructure.repositories.customers;

import br.com.meuponto.domain.features.customers.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {
    public static Specification<Customer> filter(String filter) {
        return (root, query, builder) -> {
            var corporateNameFilter = builder.like(root.get("corporateName"), "%" + filter + "%");
            var cnpjFilter = builder.like(root.get("cnpj"), "%" + filter + "%");
            return builder.or(corporateNameFilter, cnpjFilter);
        };
    }
}
