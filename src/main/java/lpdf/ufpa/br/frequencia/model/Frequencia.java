package lpdf.ufpa.br.frequencia.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Frequencia")
public class Frequencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_frequencia", nullable = false, unique = true)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entrada_frequencia", nullable = false)
    private Date entrada;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "saida_frequencia", nullable = true)
    private Date saida;

    @Column(name = "fechouPonto")
    private Boolean fechouPonto;
}
