package xz.jingle;

/**
 * Created by Jinhua on 2016/10/19.
 */
public class ProjectPathTest {
	public static void main(String[] args) {
		ProjectPathTest root = new ProjectPathTest();
		//取得根目录路径
		String rootPath = root.getClass().getResource("/").getFile().toString();
		//当前目录路径
		String currentPath1 = root.getClass().getResource(".").getFile().toString();
		//当前目录的上级目录路径
		String parentPath = root.getClass().getResource("../").getFile().toString();
		
//		System.out.println(Arrays.toString(new File(rootPath).list()));
//		System.out.println(parentPath);
		String str = ProjectPathTest.class.getClassLoader().getResource("").getPath();
		System.out.println(str);
		
	}
}
