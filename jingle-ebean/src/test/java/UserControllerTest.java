
import io.ebean.Ebean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import xz.model.User;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"application.yml"})
public class UserControllerTest {
	@Test
	public void testForEach() {
		List<User> data  = Ebean.find(User.class).findList();
		for (User i :data){
			System.out.println(i);
		}
	}
}