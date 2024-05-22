package programacion3.proyectoAeropuertoLP.model.entity.AuthAndRegister;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import programacion3.proyectoAeropuertoLP.model.entity.BaseEntity;
import programacion3.proyectoAeropuertoLP.model.entity.Cliente;
import programacion3.proyectoAeropuertoLP.model.entity.Empleados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class Users extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 255)
    @Column(name = "nickname")
    private String nickname;

    @NotBlank
    @NotEmpty
    @Email
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=]).*$", message = "El formato de la contraseña no es válido")
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));//
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> clienteList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleados> empleadosList = new ArrayList<>();

}