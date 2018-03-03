###Java用反射简单构建工厂，以及调用有参构造函数初始化实例  

POI方式和JXL除了需要创建行对象，以及需要创建输出流之外，并无太大区别。

源码：

```
import java.io.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.*;

public class Xz_Excel_POI {
	public static void main(String[] args) {
		POIExcel p = new POIExcel();
		try {
			//主方法
			p.createExcel("excel2.xls");
			p.readExcel("excel2.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ok");
	}
}

class POIExcel{
	
	public void createExcel(String fileName) throws Exception{
		
		//创建工作簿、工作表、行、表头
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet("sheet001");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cellName = row.createCell((short) 0);
		HSSFCell cellAge = row.createCell((short) 1);
		cellName.setCellValue("name");
		cellAge.setCellValue("age");
		
		//填充内容
		for (int i = 1; i < 100; i++) {
			row = sheet.createRow(i);
			cellName = row.createCell((short) 0);
			cellAge = row.createCell((short) 1);
			cellName.setCellValue("name_"+i);
			cellAge.setCellValue(""+new Random().nextInt(80));
		}	
		
		//输出文件
		FileOutputStream   fo  =  new FileOutputStream(new File(fileName));
		book.write(fo);
		fo.flush();
		fo.close();
	}
	
	public List readExcel(String fileName) throws Exception{
		
		//声明返回值，创建一系列对象
		List<String> cells = new ArrayList();
		List<List<String>> rows = new ArrayList();
		 HSSFWorkbook  book  =  new HSSFWorkbook(new FileInputStream(fileName));
		  HSSFSheet   sheet  =  book.getSheetAt(0);
		  
		  //当本行不为空，读取本行然后跳到下一行
		  for (int i = 0; sheet.getRow(i)!=null; i++) {
			HSSFRow row = sheet.getRow(i);
			//读取本行单元格，存入List
			for (int j = 0; j <row.getLastCellNum(); j++) {
				HSSFCell cell = row.getCell(j);
				cells.add(cell.getStringCellValue());
				System.out.print(cell.getStringCellValue()+"\t");
			}
			rows.add(cells);
			System.out.println("");
		}
		return rows;
		}
}
```