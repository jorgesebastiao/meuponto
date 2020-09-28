package br.com.meuponto.distribution.controllers.base;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.stream.Collectors;

@PreAuthorize("isAuthenticated()")
public class ApiBaseController {

    private final ModelMapper modelMapper;

    public ApiBaseController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected <TSource, TDestination> Page<TDestination> HandlePageResult(Pageable pageable, Page<TSource> sources, Class<TDestination> destination) {
        return new PageImpl<>(sources.stream()
                .map(source -> sourceToDestination(source, destination))
                .collect(Collectors.toList()), pageable, sources.getTotalElements());
    }

    protected <TSource, TDestination> TDestination sourceToDestination(TSource source, Class<TDestination> destination) {
        return modelMapper.map(source, destination);
    }
}
