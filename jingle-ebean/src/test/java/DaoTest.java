
import io.ebean.Ebean;
import io.ebean.Expr;
import org.junit.Test;
import xz.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * 跑任意一个测试ebean会自动生成建表语句,并清空原有数据.
 * 所以建议在test-ebean.properties中配置h2数据库
 */
public class DaoTest {
	private User user1 = new User("Tony","Tom@qq.com");
	private User user2 = new User("Nancy","Nancy@qq.com");
	private Dept dept1 = new Dept("英雄科");
	private Dept dept2 = new Dept("支援科");
	private Address ad1 = new Address().setLocation("妖都");
	private Address ad2 = new Address().setLocation("魔都");
	private UserTag ut2 = new UserTag().setTagName("二逼青年");
	private UserTag ut3 = new UserTag().setTagName("三和大神");
	private UserTag ut4 = new UserTag().setTagName("四有青年");

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

//		dept2.addChild(user2);
	}

	@Test
	public void testManyToOne() {
		dept1.addUser(user1);
		dept1.addUser(user2);

		Ebean.save(dept1);
		Ebean.save(dept2);
	}

	@Test
	public void testManyToMany() {
//		user1.addUserTag(ut1);
//		user1.addUserTag(ut2);
//		user2.addUserTag(ut1);
//
//		Ebean.save(user1);
//		Ebean.save(user2);

		ut2.addChild(ut3);
		ut2.addChild(ut4);
		Ebean.save(ut2);
	}
	@Test
	public void testEnum() {
		user1.anAssert = Assert.FUND;
		user2.anAssert = Assert.SHARE;

		Ebean.save(user1);
		Ebean.save(user2);

		System.out.println(user1.anAssert);
		System.out.println(user1.anAssert.name());
		System.out.println(user1.anAssert.ordinal());
		System.out.println(user1.anAssert.compareTo(Assert.FUND));//比较序号而已
		System.out.println(user1.anAssert.getName());
	}

	@Test
	public void testQuery() {
		Ebean.save(user1.setDept(dept1));
		Ebean.save(user2);

		List<User> users = Ebean.find(User.class)
				//只查询name,其他为空
				.select("name")
				//只查询dept的name?怎么不太对
				.fetch("dept","name")
				//用Expr创建复杂语句like还要自己定义通配符
				.where(Expr.ilike("name","%n%"))
				.orderBy("name desc")
				.findList();
		users.forEach(u-> System.out.println(u.allToString()));
	}

	@Test
	public void testOnePlusN() {
		List<User> us = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			User user = new User(""+i,""+i);
			us.add(user);
			user.setDept(dept1);
//			dept1.addChild(user);
		}
		//就算是这种方式,还是一条条插入
		Ebean.saveAll(us);

		Dept dept = Ebean.find(Dept.class,1);
		dept.users.forEach(System.out::println);
	}




	void showTables(String msg) {
		System.out.println(msg+" =================================================");
		System.out.println(Ebean.find(User.class).findList());
		System.out.println(Ebean.find(Dept.class).findList());
	}
}