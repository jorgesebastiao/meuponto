package br.com.meuponto.infrastructure.repositories.permissions;

import br.com.meuponto.domain.features.permissions.Permission;
import br.com.meuponto.domain.features.permissions.PermissionType;
import br.com.meuponto.infrastructure.repositories.base.RepositoryBase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends RepositoryBase<Permission, Long> {

    Optional<Permission> findByPermission(PermissionType  permission);
}
