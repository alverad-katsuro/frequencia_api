package lpdf.ufpa.br.frequencia.dto.auth;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
