package excel1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	
	public excel(File filename) {
		List cellData = new ArrayList();
		try {
			
			FileInputStream fileInputStream = new FileInputStream(filename);
			XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
			
			
			XSSFSheet hssfSheet = workBook.getSheetAt(0);
			Iterator rowIterator =hssfSheet.rowIterator();
			while(rowIterator.hasNext()) {
				XSSFRow hssfRow = (XSSFRow) rowIterator.next();
				Iterator iterator = hssfRow.cellIterator();
				List cellTemp = new ArrayList();
				
				while(iterator.hasNext()) {
					XSSFCell hssXssfCell = (XSSFCell) iterator.next();
					
					cellTemp.add(hssXssfCell);
				}
				cellData.add(cellTemp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		obtener(cellData);
	}
	private void obtener(List cellDataList) {
		
		for (int i = 0; i <cellDataList.size(); i++) {
			List cellTempList = (List) cellDataList.get(i);
			for (int j = 0; j < cellTempList.size(); j++) {
				XSSFCell hsXssfCell = (XSSFCell) cellTempList.get(j);
				
				String stringCellValue = hsXssfCell.toString();
				System.out.print(stringCellValue+" ");
				
			}
			System.out.println();
			
		}
		
	}
	public static void main(String[] args) {
		
		File f=new File("");
		if(f.exists()) {
			excel obj = new excel(f);
			
		}
	}


}
