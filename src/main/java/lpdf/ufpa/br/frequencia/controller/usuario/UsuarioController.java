package lpdf.ufpa.br.frequencia.controller.usuario;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lpdf.ufpa.br.frequencia.model.Usuario;
import lpdf.ufpa.br.frequencia.services.usuario.UsuarioService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    @GetMapping(value = "/all")
    public Iterable<Usuario> getALl(){
        return usuarioService.findAll();
    }

    @GetMapping(value = "/one")
    public Usuario getOne(){
        return usuarioService.findByUsername("admin");
    }

    @PostMapping(value="/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        usuario = usuarioService.save(usuario);        
        return ResponseEntity.ok(usuario);
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR')")
    //@Secured({"ADMINISTRADOR"})   
    @GetMapping(value = "/teste")
    public Collection<? extends GrantedAuthority> teste(Authentication auth){
        return auth.getAuthorities();
    }
    
}
