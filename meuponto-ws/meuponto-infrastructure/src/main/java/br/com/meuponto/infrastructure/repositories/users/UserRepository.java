package br.com.meuponto.infrastructure.repositories.users;

import br.com.meuponto.domain.features.users.User;
import br.com.meuponto.infrastructure.repositories.base.RepositoryBase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends RepositoryBase<User, Long> {

    Optional<User> findByEmail(String email);

}
