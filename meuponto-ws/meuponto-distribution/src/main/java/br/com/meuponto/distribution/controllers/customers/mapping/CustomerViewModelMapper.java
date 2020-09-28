package br.com.meuponto.distribution.controllers.customers.mapping;

import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerResumeViewModel;
import br.com.meuponto.domain.features.customers.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class CustomerViewModelMapper {

    public static void profile(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Customer.class, CustomerResumeViewModel.class);
        modelMapper.addMappings(customerCustomerResumeViewModelPropertyMap());
    }

    static PropertyMap<Customer, CustomerResumeViewModel> customerCustomerResumeViewModelPropertyMap() {
        return new PropertyMap<>() {
            protected void configure() {

            }
        };
    }
}
