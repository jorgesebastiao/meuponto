package br.com.meuponto.domain.features.users;

import br.com.meuponto.domain.features.permissions.Permission;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDomainServiceImpl implements  UserDomainService {

    @Override
    public User createUser(User user, Permission permission) {
        user.setActive(true);
        var permissions = new HashSet<Permission>();
        permissions.add(permission);
        user.setPermissions(permissions);
        return user;
    }
}
