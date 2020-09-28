package br.com.meuponto.domain.features.collaborators;

import br.com.meuponto.domain.common.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "collaborators")
public class Collaborator extends EntityBase<Integer> {
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String registration;
    @Column(nullable = false, unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private LocalDateTime admissionDate;
}
