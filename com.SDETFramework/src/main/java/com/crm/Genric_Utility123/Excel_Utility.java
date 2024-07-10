package com.crm.Genric_Utility123;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
/**this method is use to fetch the data
 * @param sheetname
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 * @author MADHU
 */
	public String getDataFromExcel(String sheetname,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./Excel/Madhu.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sht = book.getSheet(sheetname);
		Row row = sht.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;
	}
}


