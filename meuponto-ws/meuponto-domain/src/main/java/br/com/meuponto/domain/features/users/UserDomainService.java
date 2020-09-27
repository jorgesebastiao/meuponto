package br.com.meuponto.domain.features.users;

import br.com.meuponto.domain.features.permissions.Permission;

public interface UserDomainService {
    User createUser(User user, Permission permission);
}
