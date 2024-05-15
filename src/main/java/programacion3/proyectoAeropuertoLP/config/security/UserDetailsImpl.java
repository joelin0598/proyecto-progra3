package programacion3.proyectoAeropuertoLP.config.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import programacion3.proyectoAeropuertoLP.model.entity.UserEntity;


import java.util.Collection;


@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UserEntity userEntity;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getRole(){
        return userEntity.getRol().getNombreRol();
    }

    public Integer getUserId() {
        return userEntity.getId();
    }

    public String getNombre(){
        return userEntity.getNickname();
    }

    public String getTipoUsuario(){
        return userEntity.getTipoUsuario();
    }
}
