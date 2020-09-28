package br.com.meuponto.distribution.controllers.collaborators;

import br.com.meuponto.application.collaborators.queries.CollaboratorLoadAllQuery;
import br.com.meuponto.distribution.controllers.base.ApiBaseController;
import br.com.meuponto.distribution.controllers.collaborators.viewmodels.CollaboratorResumeViewModel;
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
@RequestMapping("/collaborators")
@Api(value="collaborators" ,description="collaborators")
public class CollaboratorController extends ApiBaseController {
    private final Mediator mediator;

    public CollaboratorController(ModelMapper modelMapper, Mediator mediator) {
        super(modelMapper);
        this.mediator = mediator;
    }

    @ApiOperation(value = "View a list of collaborators", response = CollaboratorResumeViewModel.class)
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('read')")
    public Page<CollaboratorResumeViewModel> getAll(@RequestParam(required = false, defaultValue = "") String filter, Pageable pageable) {
        var query = CollaboratorLoadAllQuery.builder()
                .filter(filter)
                .pageable(pageable)
                .build();
        return HandlePageResult(pageable, mediator.dispatch(query), CollaboratorResumeViewModel.class);
    }
}
