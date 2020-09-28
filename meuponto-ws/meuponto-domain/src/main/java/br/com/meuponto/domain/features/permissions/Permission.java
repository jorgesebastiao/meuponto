package br.com.meuponto.domain.features.permissions;

import br.com.meuponto.domain.common.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "permissions")
public class Permission extends EntityBase<Integer> {
    @Column(nullable = false, unique = true)
    private PermissionType permission;
}
