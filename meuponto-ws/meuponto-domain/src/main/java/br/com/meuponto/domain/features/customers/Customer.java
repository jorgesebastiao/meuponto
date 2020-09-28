package br.com.meuponto.domain.features.customers;

import br.com.meuponto.domain.common.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "customers")
public class Customer extends EntityBase<Integer> {
    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;
    @Column(nullable = false, length = 120)
    private String corporateName;
    @Column(nullable = false, length = 120)
    private String tradeName;
}
