package br.com.meuponto.security.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("meuponto-security")
public class MeuPontoSecutiryProperty {

    @Getter
    @Setter
    private List<String> allowedOrigin = new ArrayList<>();

    @Getter
    @Setter
    private Security security;

    public static class Security {

        @Getter
        @Setter
        private boolean enableHttps;

        @Getter
        @Setter
        private String oauthPath;
    }
}
