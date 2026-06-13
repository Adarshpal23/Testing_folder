//package utility_Files;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//public class Excel_Utility {
//public static String getCellData(String path, String sheet, int row, int col) throws IOException {
//	FileInputStream fis = new FileInputStream(path);
//	//XSSFWorkbook workbook = new XSSFWorkbook();
//	XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	DataFormatter formatter = new DataFormatter();
//	System.out.println("Excel Path = " + path);
//	System.out.println("Sheet Name = " + sheet);
//	if(sheet == null) {
//	    throw new RuntimeException(
//	        "Sheet '" + sheet + "' not found. Available sheets are: "
//	    );
//	}
//
//	String data = sheet.getrow(row)
//	                   .getCell(col)
//	                   .getStringCellValue();
//	for(int i=0; i<workbook.getNumberOfSheets(); i++) {
//	    System.out.println("Sheet found: [" + workbook.getSheetName(i) + "]");
//	}
//	workbook.close();
//	System.out.println("Excel Path : " + path);
//    
//	return data;
//	
//	
//}
//
//}

package utility_Files;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {

    public static String getCellData(String path,
                                     String sheetName,
                                     int row,
                                     int col) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        System.out.println("Excel Path = " + path);
        System.out.println("Sheet Name = " + sheetName);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            System.out.println("Sheet found : [" + workbook.getSheetName(i) + "]");
        }

        XSSFSheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new RuntimeException("Sheet '" + sheetName + "' not found.");
        }

        DataFormatter formatter = new DataFormatter();

        String data = formatter.formatCellValue(
                sheet.getRow(row).getCell(col));

        workbook.close();
        fis.close();

        return data;
    }
}
