package mu.webshop.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipleAuthenticationToken extends AbstractAuthenticationToken {
    private final UserPrincipall principal;
    public UserPrincipleAuthenticationToken(UserPrincipall principal) {
        super(principal.getAuthorities());
        this.principal = principal;
        setAuthenticated(true);
    }
    @Override
    public Object getCredentials() {
        return null;
    }
    @Override
    public UserPrincipall getPrincipal() {
        return principal;
    }
}
