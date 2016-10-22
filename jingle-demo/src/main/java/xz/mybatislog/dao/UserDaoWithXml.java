package xz.mybatislog.dao;

import xz.mybatislog.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Jinhua on 2016/8/31.
 */
public class UserDaoWithXml {
	SqlSession session;
	public UserDaoWithXml(){
		String resource = "conf.xml";
		InputStream is = UserDaoWithXml.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//Reader reader = Resources.getResourceAsReader(resource);
		//SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		session = sessionFactory.openSession();
	}
	public User findUserByAge(int age) {
		String statement = "com.xz.tools.mybatislog.mapping.userMapper.getUser";
		User user = session.selectOne(statement, age);
		return user;
	}
}
