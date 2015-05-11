package pl.mrasoft.jbpm.parallel;

import org.jbpm.executor.ExecutorServiceFactory;
import org.kie.internal.executor.api.ExecutorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@ImportResource(value = {"classpath:config/jee-tx-context.xml",
        "classpath:config/jpa-context.xml", "classpath:config/jbpm-context.xml",})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(initMethod = "init")
    @ConfigurationProperties(prefix = "jbpm.executor")
    public ExecutorService jbpmExecutorService(
            EntityManagerFactory emf) throws Exception {

        ExecutorServiceFactory factory = new ExecutorServiceFactory();
        ExecutorService service = factory.newExecutorService(emf);

        return service;
    }
}
