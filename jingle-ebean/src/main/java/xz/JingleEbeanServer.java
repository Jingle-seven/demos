package xz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JingleEbeanServer {
	public static void main(String[] args) {
		new SpringApplicationBuilder(JingleEbeanServer.class).run(args);
	}
}