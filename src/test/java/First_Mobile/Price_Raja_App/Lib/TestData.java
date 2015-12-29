package First_Mobile.Price_Raja_App.Lib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestData {

	public static final String f = ".\\Data\\Houzify_TestData.xlsx";
	public static final String sheet = "QR_TestData";
	
	public static String getValue(String testCaseId, String dataName) throws InvalidFormatException, IOException, NullPointerException{
		String value = "";
		int rowIndex=0;
		int cellIndex=0;
		Workbook book = WorkbookFactory.create(new File(TestData.f));
		 Sheet sheet = book.getSheet(TestData.sheet);
		 for(int i = 0;i<sheet.getRow(0).getLastCellNum();i++){
			 if(sheet.getRow(0).getCell(i)!=null && sheet.getRow(0).getCell(i).toString().equals(dataName)){
				 //System.out.println("cell name : "+ sheet.getRow(0).getCell(i).toString() + "cell index : "+ i);
				 cellIndex=i;
			 }
		 }
		 for(int i=0;i<=sheet.getLastRowNum();i++){
			 if(sheet.getRow(i)!=null && sheet.getRow(i).getCell(0).toString().equals(testCaseId)){
				// System.out.println("row name : "+ sheet.getRow(i).getCell(0).toString() + "row index : "+ i);
				 rowIndex = i;
			 }
		 }
		 value = sheet.getRow(rowIndex).getCell(cellIndex).toString();
		return value;
	}
	
	
	public static List<String> getValueByRow(String testCaseId) throws InvalidFormatException, IOException{
		List<String> data = new ArrayList<String>();
		Workbook book = WorkbookFactory.create(new File(TestData.f));
		Sheet sheet = book.getSheet(TestData.sheet);
		int rowIndex=0;
		for(int i=0;i<=sheet.getLastRowNum();i++){
			 if(sheet.getRow(i)!=null && sheet.getRow(i).getCell(0).toString().equals(testCaseId)){
				// System.out.println("row name : "+ sheet.getRow(i).getCell(0).toString() + "row index : "+ i);
				 rowIndex = i;
			 }
		}
		Iterator<Cell> cell = sheet.getRow(rowIndex).iterator();
		while(cell.hasNext()){
			Cell v = cell.next();
			data.add(v.getStringCellValue());
		}	
		return data;
	}
	
}
