package lpdf.ufpa.br.frequencia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.RequiredArgsConstructor;
import lpdf.ufpa.br.frequencia.services.usuario.UsuarioService;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    private final UsuarioService usuarioService;
                              
    @Bean
    public UserDetailsService userDetailsService() {
      return this.usuarioService;
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        return new ProviderManager(authProvider);
    }

}
