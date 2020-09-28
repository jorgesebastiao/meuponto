package br.com.meuponto.distribution.controllers.customers.mapping;

import br.com.meuponto.application.customers.queries.CustomerGetQuery;
import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerResumeViewModel;
import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerViewModel;
import br.com.meuponto.domain.features.customers.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class CustomerViewModelMapper {

    public static void profile(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Customer.class, CustomerResumeViewModel.class);
        modelMapper.addMappings(customerCustomerResumeViewModelPropertyMap());

        modelMapper.createTypeMap(Customer.class, CustomerViewModel.class);
        modelMapper.addMappings(customerCustomerViewModelPropertyMap());
    }

    static PropertyMap<Customer, CustomerResumeViewModel> customerCustomerResumeViewModelPropertyMap() {
        return new PropertyMap<>() {
            protected void configure() {

            }
        };
    }

    static PropertyMap<Customer, CustomerViewModel> customerCustomerViewModelPropertyMap() {
        return new PropertyMap<>() {
            protected void configure() {

            }
        };
    }
}
