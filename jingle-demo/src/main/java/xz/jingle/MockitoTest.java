package xz.jingle;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Jinhua on 2017/3/20.
 */

/**
 * 测试dogDao
 */
public class MockitoTest {
	
	@Test
	public void testDog(){
		Dog dog = mock(Dog.class);
		when(dog.getName()).thenReturn("西湖小黄鸡");
		
		DogDao dao = new DogDao();
		Dog newDog = dao.getDog();
		dao.changeDogName(dog,"东都哈士奇");
		
		verify(dog).setName("东都哈士奇");
		assertEquals("西湖小黄鸡",dog.getName());
		assertEquals(newDog.getName(),new Dog().getName());
	}
}
class DogDao{
	public Dog getDog(){
		return new Dog();
	}
	public void changeDogName(Dog d,String newName){
		d.setName(newName);
	}
}
