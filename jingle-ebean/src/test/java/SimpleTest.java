
import io.ebean.Ebean;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import xz.model.Dept;
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
public class SimpleTest {
	//BeanUtils.populate 强大但使用相当繁琐,滚蛋吧
	@Test
	public void testUtil() throws InvocationTargetException, IllegalAccessException {
		User u = new User("tom","tom@qq.com");
		Map<String,Object> map = new HashMap<>();
		map.put("name","");
		BeanUtils.populate(u,map);
		System.out.println(XKit.castToMap(u));
		System.out.println(map);
	}
}