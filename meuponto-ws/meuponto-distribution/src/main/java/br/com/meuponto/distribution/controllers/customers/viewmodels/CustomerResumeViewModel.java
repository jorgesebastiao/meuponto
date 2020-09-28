package br.com.meuponto.distribution.controllers.customers.viewmodels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResumeViewModel {
    private Integer id;
    private String cnpj;
    private String corporateName;
    private String tradeName;
}
