package xz.mybatislog.dao;

import xz.mybatislog.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {
	/**
	 * 用注解只写接口即可，不必写实现类（mybatis动态生成），神奇,但是需要spring支持
	 * @param user
	 * @return
	 */
	// 使用@Insert注解指明add方法要执行的SQL
	@Insert("insert into user(name,age,location) values(#{name},#{age},#{location})")
	public int add(User user);

	// 使用@Delete注解指明deleteByName方法要执行的SQL
	@Delete("delete from user where name=#{name}")
	public int deleteByName(String name);

	// 使用@Update注解指明update方法要执行的SQL
	@Update("update user set name=#{name},age=#{age} where name=#{name}")
	public int update(User user);

	// 使用@Select注解指明getByName方法要执行的SQL
	@Select("select * from user where name=#{name}")
	public User findByName(String name);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select("select * from user")
	public List<User> findAll();
}
