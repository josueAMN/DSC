package lab.lab.lab.api.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lab.lab.lab.api.filter.JWTFilter;
import lab.lab.lab.api.user.UserDTO;
import lab.lab.lab.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Autowired
    private UserService userService;
    public static final String TOKEN_KEY = "josue123";

    public LoginResponse autentica(UserDTO usuario) {

        if (!userService.validaUsuarioSenha(usuario)) {
            return new LoginResponse("Usuario ou senha invalidos.");
        }

        String token = geraToken(usuario.getEmail());
        return new LoginResponse(token);
    }

    private String geraToken(String email) {
        return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(email)
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 180 * 60 * 1000)).compact();// 3 min
    }

    public String getSujeitoDoToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new SecurityException("Token inexistente ou mal formatado!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = authorizationHeader.substring(JWTFilter.TOKEN_INDEX);

        String subject = null;
        try {
            subject = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException e) {
            throw new SecurityException("Token invalido ou expirado!");
        }
        return subject;
    }

}
