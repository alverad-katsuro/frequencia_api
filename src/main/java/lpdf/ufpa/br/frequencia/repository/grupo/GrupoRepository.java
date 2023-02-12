package lpdf.ufpa.br.frequencia.repository.grupo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import lpdf.ufpa.br.frequencia.model.Grupo;

public interface GrupoRepository extends CrudRepository<Grupo, Integer> {
    public Optional<Grupo> findByNomeGrupo(String nomeGrupo);
}
