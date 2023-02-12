package lpdf.ufpa.br.frequencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGrupoId {

    @Column(name = "usuarioId", nullable = false, unique = true)
    private Integer usuarioId;
    
    @Column(name = "grupoId", nullable = false, unique = true)
    private Integer grupoId;
}
