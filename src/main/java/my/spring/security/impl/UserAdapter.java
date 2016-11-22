package my.spring.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import my.spring.security.entity.Role;
import my.spring.security.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAdapter implements UserDetails {
    private static final long serialVersionUID = 1L;
    private User m_user;

    public UserAdapter(User user) {
        m_user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : m_user.getRoles()) {
            authorities.add(new RoleAdapter(role));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return m_user.getPassword();
    }

    @Override
    public String getUsername() {
        return m_user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public int getUserId() {
        return m_user.getId();
    }
}
