/*
package com.tech1.personelmanagementsystem.Core.Utilities.Auth;

import com.tech1.personelmanagementsystem.Core.Entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

*/
/*    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
*//*
*/
/*        // Kullanıcının rollerini döndürme işlemi
        return user.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());*//*
*/
/*
    }*//*


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // Kullanıcının şifresini döndürme işlemi
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Kullanıcının email adresini döndürme işlemi
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Kullanıcının hesabının süresinin dolup dolmadığını kontrol etme işlemi
        return true; // Örnek olarak herhangi bir hesap süresi kontrolü yapmıyoruz.
    }

    @Override
    public boolean isAccountNonLocked() {
        // Kullanıcının hesabının kilitli olup olmadığını kontrol etme işlemi
        return true; // Örnek olarak herhangi bir hesap kilitleme kontrolü yapmıyoruz.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Kullanıcının kimlik bilgilerinin süresinin dolup dolmadığını kontrol etme işlemi
        return true; // Örnek olarak herhangi bir kimlik bilgisi süresi kontrolü yapmıyoruz.
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
*/
