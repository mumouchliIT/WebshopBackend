package mu.webshop.config;
import mu.webshop.entity.AdminEntity;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class TokenGenerator {
    private final TokenProperties properties ;
    public String generateToken(AdminEntity admin) {
        // Set the expiration time for the token (e.g., 1 hour)
        long expirationMillis = System.currentTimeMillis() + 3600000; // 1 hour
        return JWT.create()
                .withSubject(admin.getEmail())
                .withExpiresAt(new Date(expirationMillis))
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
    public boolean validateToken(String token) {
        try {
            // You can add more validation logic here if needed
            JWT.require(Algorithm.HMAC256(properties.getSecretKey())).build().verify(token);
            return true;
        } catch (Exception e) {
            // Token verification failed
            return false;
        }
    }
}
