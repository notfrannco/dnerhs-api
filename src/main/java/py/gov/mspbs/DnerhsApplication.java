package py.gov.mspbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import py.gov.mspbs.config.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DnerhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnerhsApplication.class, args);
	}

}
