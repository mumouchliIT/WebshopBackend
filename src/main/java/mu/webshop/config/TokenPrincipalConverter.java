package mu.webshop.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class TokenPrincipalConverter {
    public UserPrincipall convert(DecodedJWT jwt){
        return UserPrincipall.builder()
                .email(String.valueOf(jwt.getSubject()))
                .build();
    }
}
