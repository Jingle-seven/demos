###Java实现简单Excel文件读写（POI）  

Java并未提供读取Excel的工具类，所以一般要导入外部Jar包。目前主流有两个包，JXL和POI，本文使用JXL包。
下面的代码只提供了基本读写方法，样式之类并未涉及。
生成的文件在项目根文件夹。  
源码：
```
import java.io.*;
import java.util.*;
import jxl.*;
import jxl.write.*;

public class XZ_Excel {
	public static void main(String[] args) {
		
		JxlExcel j = new JxlExcel();
		try {
			j.createExcel("excel1.xls");//创建文件
			j.readExcel("excel1.xls");//读取文件，此处有返回值但未接收
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("OK");
	}
}

class JxlExcel {
	public void createExcel(String fileName) throws Exception {
		
		//创建工作簿工作表对象
		WritableWorkbook book = Workbook.createWorkbook(new File(fileName));
		WritableSheet sheet = book.createSheet("sheet001", 0);

		//创建表头
		Label lab = null;
		lab = new Label(0, 0, "name");
		sheet.addCell(lab);
		lab = new Label(1, 0, "age");
		sheet.addCell(lab);

		//填充内容
		for (int j = 1; j < 100; j++) {
			sheet.addCell(new Label(0, j, "name_"+j));
		}
		for (int j = 1; j < 100; j++) {
			Random rand = new Random();
			int ran = rand.nextInt(80);
			sheet.addCell(new Label(1, j,ran+""));
		}
		
		//输出文件
		book.write();
		book.close();
	}
	
	public List readExcel(String fileName) throws Exception{
		
		//声明返回值
		List<String> cells = new ArrayList();
		List<List<String>> rows= new ArrayList();
		
		//根据现有文件创建工作簿工作表对象
		Workbook book = Workbook.getWorkbook(new File(fileName));
		Sheet sheet = book.getSheet("sheet001");
		
		//获得行数、列数
		int countColu = sheet.getColumns();
		int countRow = sheet.getRows();
		
		//读取内容放入List，并且打印到控制台
		for (int i = 0; i < countRow; i++) {
			for (int j = 0; j <countColu; j++) {
				Cell cell = sheet.getCell(j, i);
				String s = cell.getContents();
				cells.add(s);
				System.out.print(s+"\t");
			}
			rows.add(cells);
			System.out.println("");
		}
		return rows;
		}
}
```