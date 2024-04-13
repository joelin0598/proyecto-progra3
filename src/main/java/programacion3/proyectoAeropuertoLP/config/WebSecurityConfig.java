package programacion3.proyectoAeropuertoLP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService(){
        return new UserDetailsServiceImpl();
    }
}
