package br.com.meuponto.infrastructure.repositories.customers;

import br.com.meuponto.domain.features.customers.Customer;
import br.com.meuponto.infrastructure.repositories.base.RepositoryBase;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends RepositoryBase<Customer, Integer> {

    boolean existsByCnpj(String cnpj);
}
