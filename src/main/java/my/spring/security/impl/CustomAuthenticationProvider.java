package my.spring.security.impl;

import java.util.Collection;

import my.spring.security.entity.User;
import my.spring.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private UserService m_userService;

    public CustomAuthenticationProvider(UserService userService) {
        m_userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = m_userService.getUserByName(username);

        UserAdapter adapter = new UserAdapter(user);
        //adapter.getAuthorities().iterator().next().getAuthority()
        if (user == null) {
            throw new BadCredentialsException("Username not found.");
        }

        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = adapter.getAuthorities();

        return new UsernamePasswordAuthenticationToken(adapter, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}