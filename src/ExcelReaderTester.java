import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderTester {
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new File("sample.xls"));
		Sheet sheet = workbook.getSheetAt(0);
		
		 int i = 0;
		for(Row row : sheet)
		{
			if(i == 0 )
			{
				i++;
				continue;
			}
			
			String studentId =  row.getCell(0).getStringCellValue();
			String courseCode =  row.getCell(1).getStringCellValue();
			String courseName = row.getCell(2).getStringCellValue();
			int teacherID = (int) row.getCell(3).getNumericCellValue();
			String teacherInitial = row.getCell(4).getStringCellValue();
			String teacherName = row.getCell(5).getStringCellValue();
			Date dateCompleted = row.getCell(6).getDateCellValue();
			String grade = row.getCell(7).getStringCellValue();
			
			System.out.println(studentId + "  "+courseCode + " "+courseName + " "+teacherID + " "+teacherInitial + " "+teacherName+ " "+dateCompleted + " "+grade);
		}
		
	}

}
