package MuWebshop.Webshop.Config;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenPrincipalConverter {
    public UserPrincipall convert(DecodedJWT jwt){
        return UserPrincipall.builder()
                .email(String.valueOf(jwt.getSubject()))
                .build();
    }
}
