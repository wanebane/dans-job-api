package com.rivaldy.dans.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rivaldy.dans.enumerate.Permission.*;

@AllArgsConstructor
public enum Role {

    ADMIN(Set.of(ADMIN_CREATE, ADMIN_READ, ADMIN_UPDATE, ADMIN_DELETE)),
    COMPANY(Set.of(COMPANY_CREATE, COMPANY_READ, COMPANY_UPDATE, COMPANY_DELETE)),
    JOB_SEEKER(Set.of(JOB_SEEKER_CREATE, JOB_SEEKER_READ, JOB_SEEKER_UPDATE, JOB_SEEKER_DELETE));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }

}
