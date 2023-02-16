package lpdf.ufpa.br.frequencia.services.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lpdf.ufpa.br.frequencia.model.Usuario;
import lpdf.ufpa.br.frequencia.repository.usuario.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(login).orElseThrow();
    }

    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Iterable<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    
}
