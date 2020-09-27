package br.com.meuponto.distribution;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "br.com.meuponto", exclude = RepositoryRestMvcAutoConfiguration.class)
public class DistributionApplication {

    private final ApplicationContext applicationContext;

    @Autowired
    public DistributionApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(DistributionApplication.class, args);
    }

    @Bean
    public Mediator mediator() {
        return new SpringMediator(new SpringRegistry(applicationContext));
    }
}
