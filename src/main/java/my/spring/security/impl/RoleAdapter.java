package my.spring.security.impl;

import my.spring.security.entity.Role;

import org.springframework.security.core.GrantedAuthority;

public class RoleAdapter implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    Role m_role;

    public RoleAdapter(Role role) {
        m_role = role;
    }

    @Override
    public String getAuthority() {
        return m_role.getName();
    }
}
