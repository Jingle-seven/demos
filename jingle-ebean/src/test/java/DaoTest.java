
import io.ebean.Ebean;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import xz.model.User;
import xz.util.XKit;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.junit.Assert.assertEquals;


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