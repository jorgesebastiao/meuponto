package br.com.meuponto.security;

import br.com.meuponto.domain.features.users.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class UserSystem extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;

    private final User user;

    UserSystem(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail() ,user.getPassword(), user.isActive(),true,true,true , authorities);
        this.user = user;
    }
}