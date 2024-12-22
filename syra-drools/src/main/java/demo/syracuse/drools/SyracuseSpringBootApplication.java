package demo.syracuse.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * La SpringBoot application
 */
@SpringBootApplication(scanBasePackages = { "demo.syracuse.**", "org.kie.kogito.**" })
public class SyracuseSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyracuseSpringBootApplication.class, args);
    }

    @Bean
    RuleEventListenerConfig newRuleEventListener() {
        return new RuleEventListenerConfig();
    }
    @Bean
    AgendaEventListenerConfig newAgendaEventListener() {
    	return new AgendaEventListenerConfig();
    }
}