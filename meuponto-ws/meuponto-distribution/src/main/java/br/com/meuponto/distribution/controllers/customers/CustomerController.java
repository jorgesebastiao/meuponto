package br.com.meuponto.distribution.controllers.customers;

import br.com.meuponto.application.customers.commands.CustomerCreateCommand;
import br.com.meuponto.application.customers.commands.CustomerDeleteCommand;
import br.com.meuponto.application.customers.commands.CustomerUpdateCommand;
import br.com.meuponto.application.customers.queries.CustomerGetQuery;
import br.com.meuponto.application.customers.queries.CustomerLoadAllQuery;
import br.com.meuponto.distribution.controllers.base.ApiBaseController;
import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerResumeViewModel;
import br.com.meuponto.distribution.controllers.customers.viewmodels.CustomerViewModel;
import io.jkratz.mediator.core.Mediator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

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

    @ApiOperation(value = "View a customer by id", response = CustomerViewModel.class)
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('read')")
    public ResponseEntity<CustomerViewModel> getById(@PathVariable Integer id) {
        var query = CustomerGetQuery.builder()
                .customerId(id)
                .build();
        return   ok(sourceToDestination(mediator.dispatch(query), CustomerViewModel.class));
    }

    @ApiOperation(value = "Register a customer")
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('write')")
    public ResponseEntity post(@RequestBody CustomerCreateCommand customerCreateCommand) {
        this.mediator.dispatch(customerCreateCommand);
        return status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Update a customer")
    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('write')")
    public ResponseEntity put(@RequestBody CustomerUpdateCommand customerUpdateCommand) {
        this.mediator.dispatch(customerUpdateCommand);
        return status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Delete a customer")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('write')")
    public ResponseEntity delete(@PathVariable Integer id) {
        var command = CustomerDeleteCommand.builder()
                .customerId(id)
                .build();
        this.mediator.dispatch(command);
        return ok().build();
    }
}
