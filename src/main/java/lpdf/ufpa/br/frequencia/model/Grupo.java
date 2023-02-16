package lpdf.ufpa.br.frequencia.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Grupo")
public class Grupo implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "nome_grupo", nullable = false, unique = true, length = 50)
    private String nomeGrupo;

    @JsonIgnore
    @ManyToMany(mappedBy= "grupos", fetch = FetchType.EAGER)
    private Set<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.nomeGrupo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Grupo other = (Grupo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nomeGrupo == null) {
            if (other.nomeGrupo != null)
                return false;
        } else if (!nomeGrupo.equals(other.nomeGrupo))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Grupo [id=" + id + ", nomeGrupo=" + nomeGrupo + "]";
    }
}
