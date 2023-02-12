package lpdf.ufpa.br.frequencia.services.grupo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lpdf.ufpa.br.frequencia.model.Grupo;
import lpdf.ufpa.br.frequencia.repository.grupo.GrupoRepository;

@Service
@AllArgsConstructor
public class GrupoService {
    
    private final GrupoRepository grupoRepository;

    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo findByNomeGrupo(String nomeGrupo){
        return grupoRepository.findByNomeGrupo(nomeGrupo).orElse(null);
    }
}
