import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.demo.ExcelReader;

public class Tester {

	public static void main(String[] args) {
		
		try {
			ExcelReader reader = new ExcelReader();
			
			HashMap<String, HashMap<String,String>> values = reader.getValuesFromFile();
			
			System.out.println(values);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
