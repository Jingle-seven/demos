
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"spring.config.name=jingle-conf"})
@SpringBootTest
public class DaoTest {
	@Test
	public void testSpanDao() {
	}
}