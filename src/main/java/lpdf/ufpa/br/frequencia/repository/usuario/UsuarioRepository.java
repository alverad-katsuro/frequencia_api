package lpdf.ufpa.br.frequencia.repository.usuario;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import lpdf.ufpa.br.frequencia.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}
