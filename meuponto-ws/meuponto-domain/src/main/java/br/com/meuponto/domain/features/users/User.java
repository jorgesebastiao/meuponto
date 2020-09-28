package br.com.meuponto.domain.features.users;

import br.com.meuponto.domain.common.EntityBase;
import br.com.meuponto.domain.features.permissions.Permission;
import br.com.meuponto.domain.features.permissions.PermissionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "users")
public class User extends EntityBase<Integer> {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean active;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "userPermissions", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private Set<Permission> permissions = new HashSet<>();

    public void setEmail(String email) {
        this.email = email.toLowerCase().trim();
    }

}
