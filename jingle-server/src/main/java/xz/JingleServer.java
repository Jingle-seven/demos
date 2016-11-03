package xz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JingleServer {
	
	public static void main(String[] args) {
		
		new SpringApplicationBuilder(JingleServer.class)
				.properties("spring.config.name=jingle-conf").run(args);
		//so, application.yml doesn't work
	}
}