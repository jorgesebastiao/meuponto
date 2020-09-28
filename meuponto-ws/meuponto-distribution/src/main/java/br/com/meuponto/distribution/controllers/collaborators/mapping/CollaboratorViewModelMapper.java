package br.com.meuponto.distribution.controllers.collaborators.mapping;

import br.com.meuponto.distribution.controllers.collaborators.viewmodels.CollaboratorResumeViewModel;
import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerResumeViewModel;
import br.com.meuponto.domain.features.collaborators.Collaborator;
import br.com.meuponto.domain.features.customers.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class CollaboratorViewModelMapper {

    public static void profile(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Collaborator.class, CollaboratorResumeViewModel.class);
        modelMapper.addMappings(customerCustomerResumeViewModelPropertyMap());
    }

    static PropertyMap<Collaborator, CollaboratorResumeViewModel> customerCustomerResumeViewModelPropertyMap() {
        return new PropertyMap<>() {
            protected void configure() {

            }
        };
    }
}
