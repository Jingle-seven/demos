package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import xz.dao.ISpanDao;
import xz.model.Span;

import java.util.List;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"spring.config.name=jingle-conf"})
@SpringBootTest
public class DaoTest {
	@Autowired
	ISpanDao spanDao;
	@Test
	public void testSpanDao() {
		List<Span> spans =  spanDao.findAll();
		List<Span> spans2 =  spanDao.findByTraceId(12L);
		System.out.println(spans);
		System.out.println(spans2);
	}
}