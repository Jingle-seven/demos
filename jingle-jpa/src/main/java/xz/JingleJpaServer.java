package xz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JingleJpaServer {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(JingleJpaServer.class).run(args);
	}
}