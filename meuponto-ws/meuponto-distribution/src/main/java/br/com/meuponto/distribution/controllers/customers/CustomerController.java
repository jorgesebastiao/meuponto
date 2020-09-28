package br.com.meuponto.distribution.controllers.customers;

import br.com.meuponto.application.customers.queries.CustomerLoadAllQuery;
import br.com.meuponto.distribution.controllers.base.ApiBaseController;
import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerResumeViewModel;
import io.jkratz.mediator.core.Mediator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Api(value="customers" ,description="customers")
public class CustomerController extends ApiBaseController {
    private  final Mediator mediator;

    public CustomerController(ModelMapper modelMapper, Mediator mediator) {
        super(modelMapper);
        this.mediator = mediator;
    }

    @ApiOperation(value = "View a list of customers", response = CustomerResumeViewModel.class)
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('read')")
    public Page<CustomerResumeViewModel> getAll(@RequestParam(required = false, defaultValue = "") String filter, Pageable pageable) {
        var query = CustomerLoadAllQuery.builder()
                .filter(filter)
                .pageable(pageable)
                .build();
        return HandlePageResult(pageable, mediator.dispatch(query), CustomerResumeViewModel.class);
    }
}
