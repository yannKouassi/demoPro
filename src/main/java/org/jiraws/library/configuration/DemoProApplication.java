package org.jiraws.library.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("org.jiraws.library.book.model")
@EnableJpaRepositories("org.jiraws.library.book.persistence")
@SpringBootApplication(scanBasePackages ={ "org.jiraws.library"} )

public class DemoProApplication {

    static void main ( String[] args ) {
        SpringApplication.run ( DemoProApplication.class , args );
    }

}
