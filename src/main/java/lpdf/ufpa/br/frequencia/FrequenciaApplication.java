package lpdf.ufpa.br.frequencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lpdf.ufpa.br.frequencia.util.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class FrequenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrequenciaApplication.class, args);
	}

}
