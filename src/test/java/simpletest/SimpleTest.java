package simpletest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.*;


public class SimpleTest

{

	private static String param = "";
	
	SimpleTest simple;

	public SimpleTest(String param) {

		this.param = param;

	}


	@BeforeClass
	@Parameters({ "parameter" })
	public void beforeClass(String parameter) {
		simple = new SimpleTest(parameter);
		System.out.println("Before class executed.");

	}

	
	@Test
	public void testMethod() {
		System.out.println("Value is: " + param);

	}
	
/*	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException {
        ArrayList<String> myData = new ArrayList<String>();
		
		FileInputStream file = new FileInputStream("H:\\Edureka\\Selenium\\WorkSpace\\Aricent\\src\\main\\java\\excel\\Aricent.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Aricent");
		
       Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	
	@Test()
	public void testMethod_dataProvider(String parameter) {
		System.out.println("Value is:: " + parameter);

	} */

	

}
