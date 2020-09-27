package br.com.meuponto.distribution.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("meuponto-distribution")
@Getter
@Setter
public class MeuPontoApiDistributionProperty {
    @Getter
    @Setter
    private String authServer;

    @Getter
    @Setter
    private String clientId;

    @Getter
    @Setter
    private String clientSecret;

    @Getter
    @Setter
    private String hostServer;
}
