
import io.ebean.Ebean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import xz.model.Dept;
import xz.model.User;

import java.util.List;


/**
 * 跑任意一个测试ebean会自动生成建表语句,并清空原有数据.
 * 所以建议在test-ebean.properties中配置h2数据库
 */
public class DaoTest {
	@Test
	public void testForEach() {
		List<User> data  = Ebean.find(User.class).findList();
		for (User i :data){
			System.out.println(i);
		}
	}
}