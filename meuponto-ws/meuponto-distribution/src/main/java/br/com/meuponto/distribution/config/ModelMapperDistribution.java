package br.com.meuponto.distribution.config;

import br.com.meuponto.distribution.controllers.customers.mapping.CustomerViewModelMapper;
import org.modelmapper.ModelMapper;

class ModelMapperDistribution {
    static void register(ModelMapper modelMapper) {
        CustomerViewModelMapper.profile(modelMapper);
    }
}
