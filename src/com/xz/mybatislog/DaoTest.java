package com.xz.mybatislog;

import com.xz.mybatislog.dao.UserDaoWithXml;
import org.junit.Test;

/**
 * Created by Jinhua on 2016/9/28.
 */
public class DaoTest {
	@Test
	public void testIUserDao(){
		//只写接口还需要添加spring支持
//		IUserDao ud = new IUserDao();
//		User u = ud.findByName("nancy");
	}
	@Test
	public void testUserDao(){
		UserDaoWithXml ud  = new UserDaoWithXml();
		System.out.println(ud.findUserByAge(21));
		System.out.println("");
	}
}
