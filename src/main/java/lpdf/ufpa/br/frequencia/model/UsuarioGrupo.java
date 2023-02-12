package lpdf.ufpa.br.frequencia.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UsuarioGrupo")
public class UsuarioGrupo {
    
    @EmbeddedId
    @Builder.Default
    private UsuarioGrupoId usuarioGrupoId = new UsuarioGrupoId();

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId")
    Usuario usuario;
    
    @MapsId("grupoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupoId")
    Grupo grupo;
}
