package read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readFromExcel {
	
	public List<Information> readXlsx(String path) throws IOException {
		System.out.println("is reading excel " + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook  xssfWorkbook = new XSSFWorkbook(is);
		Information inf = null; 
		List<Information> list = new ArrayList<Information>();
		for(int i=0;i<xssfWorkbook.getNumberOfSheets();i++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
			for(int j=2;j<=xssfSheet.getLastRowNum();j++) {
				XSSFRow xssfRow = xssfSheet.getRow(j);
				if(xssfRow != null) {
					inf = new Information();
					//XSSFCell id = xssfRow.getCell(0);
					XSSFCell sid = xssfRow.getCell(1);
					sid.setCellType(CellType.STRING);
					XSSFCell name = xssfRow.getCell(2);
					XSSFCell address = xssfRow.getCell(3);
					//inf.id = getValue(id);
					inf.sid = getValue(sid);
					inf.name = getValue(name);
					inf.address = getValue(address);
					list.add(inf);
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings("static-access")
	private String getValue(XSSFCell xssfCell) {
		//if(xssfCell.getCellType() == CellType.NUMERIC) {
		//	return xssfCell.getNumericCellValue()
			//return String.valueOf(xssfCell.getNumericCellValue());
		//}else {
			return String.valueOf(xssfCell.getStringCellValue());
		//}
	}
}
