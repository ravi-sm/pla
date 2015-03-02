package org.nthdimenzion.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: Samir
 * @since 1.0 13/02/2015
 */
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginDetailDto implements UserDetails {

    private Collection<String> permissions;

    private Collection<? extends GrantedAuthority> authorities;

    private Collection<String> roles;

    private String userName;

    private String password;

    UserLoginDetailDto() {

    }

    private UserLoginDetailDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static UserLoginDetailDto createUserLoginDetailVo(String userName, String password) {
        UserLoginDetailDto userLoginDetailDto = new UserLoginDetailDto(userName, password);
        return userLoginDetailDto;
    }

    public UserLoginDetailDto populateAuthorities(List<String> authorities) {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String authority : authorities) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        this.authorities = grantedAuthorities;
        return this;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public List<String> getRoles(){
        return (List<String>) roles;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
