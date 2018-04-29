
import io.ebean.Ebean;
import io.ebean.annotation.Transactional;
import org.junit.Test;
import xz.model.Address;
import xz.model.Dept;
import xz.model.User;
import xz.model.UserTag;

import static org.junit.Assert.assertEquals;


/**
 * 跑任意一个测试ebean会自动生成建表语句,并清空原有数据.
 * 所以建议在test-ebean.properties中配置h2数据库
 */
public class DaoTest {
	private User user1 = new User("Tom","Tom@qq.com");
	private User user2 = new User("Nancy","Nancy@qq.com");
	private Dept dept1 = new Dept("英雄科");
	private Dept dept2 = new Dept("支援科");
	private Address ad1 = new Address().setLocation("妖都");
	private Address ad2 = new Address().setLocation("魔都");
	private UserTag ut1 = new UserTag().setTagName("三和大神");
	private UserTag ut2 = new UserTag().setTagName("四有青年");

	@Test
	public void testOneToOne() {
		user1.setAddress(ad1);
		user2.setAddress(ad2);
		Ebean.save(user1);
		user1.setAddress(ad2);
//		Ebean.delete(user1);
		Ebean.save(user1);
	}

	@Test
	public void testOneToMany() {
		user1.setDept(dept1).setId(9L);
		user2.setDept(dept1);
		Ebean.save(user1);
		Ebean.save(user2);

		Dept dept = Ebean.find(Dept.class,1);
		User user = dept.users.get(0);
		System.out.println(user);
		user1.setName("Jim");
		System.out.println(user);
		Ebean.save(user1);
		//刷新另一个引用
		Ebean.refresh(user);
		System.out.println(user);

//		dept2.addUser(user2);
	}

	@Test
	public void testManyToOne() {
		dept1.addUser(user1);
		dept1.addUser(user2);

		Ebean.save(dept1);
		Ebean.save(dept2);
	}

	@Test
//	@Transactional
	public void testManyToMany() {
		user1.addUserTag(ut1);
		user1.addUserTag(ut2);
		user2.addUserTag(ut1);

		Ebean.save(user1);
		Ebean.save(user2);
	}



	void showTables(String msg) {
		System.out.println(msg+" =================================================");
		System.out.println(Ebean.find(User.class).findList());
		System.out.println(Ebean.find(Dept.class).findList());
	}
}