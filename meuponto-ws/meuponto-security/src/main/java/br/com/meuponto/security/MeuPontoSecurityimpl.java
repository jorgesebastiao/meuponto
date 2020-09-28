package br.com.meuponto.security;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Service;

@Service
public class MeuPontoSecurityimpl implements MeuPontoSecurity {
    private final ResourceServerTokenServices resourceServerTokenServices;

    public MeuPontoSecurityimpl(ResourceServerTokenServices resourceServerTokenServices) {
        this.resourceServerTokenServices = resourceServerTokenServices;
    }

    public Integer getUserId() {
        return (Integer) getAdditionalInformation("user_id");
    }

    private Object getAdditionalInformation(String additionalInformation) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var auth2AccessToken = resourceServerTokenServices.readAccessToken(((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue());
        return auth2AccessToken.getAdditionalInformation().get(additionalInformation);
    }
}
