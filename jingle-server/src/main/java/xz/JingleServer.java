package xz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan({"xz.dao","xz.idao"})//扫描多个包
public class JingleServer {
	
	public static void main(String[] args) {
		
		new SpringApplicationBuilder(JingleServer.class)
				.properties("spring.config.name=jingle-conf").run(args);
		//so, application.yml doesn't work
	}
}