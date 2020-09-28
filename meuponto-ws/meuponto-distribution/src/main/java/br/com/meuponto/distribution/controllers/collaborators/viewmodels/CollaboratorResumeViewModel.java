package br.com.meuponto.distribution.controllers.collaborators.viewmodels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CollaboratorResumeViewModel {
    private Integer id;
    private String cpf;
    private String name;
    private String registration;
    private LocalDateTime admissionDate;
}
