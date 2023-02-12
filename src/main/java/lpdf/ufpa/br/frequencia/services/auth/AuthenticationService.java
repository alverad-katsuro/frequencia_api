package lpdf.ufpa.br.frequencia.services.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lpdf.ufpa.br.frequencia.dto.auth.AuthenticationRequest;
import lpdf.ufpa.br.frequencia.dto.auth.AuthenticationResponse;
import lpdf.ufpa.br.frequencia.services.jwt.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );
        return AuthenticationResponse.builder().token(tokenService.generateToken(auth)).build();
    }
    
}
