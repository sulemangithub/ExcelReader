package com.demo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public HashMap<String, HashMap<String,String>> getValuesFromFile() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
	HashMap<String, HashMap<String,String>> values = new HashMap<>();	

	HashMap<String, String> slider = new HashMap<>();
	HashMap<String, String> dynamicSlider = new HashMap<>();
	HashMap<String, String> infoPanel = new HashMap<>();
	HashMap<String, String> multipleChoiceRadioBtn = new HashMap<>();
	
	Workbook workbook = WorkbookFactory.create(new File(("demo.xls")));
	Sheet sheet = workbook.getSheetAt(0);
	
	DataFormatter dataFormatter = new DataFormatter();
	
	int i = 0;
	
	for(Row row : sheet)
	{
		if(i == 0)
		{
			i++;
			continue;
		}
		
		String questionType = row.getCell(0).getStringCellValue();
		
		if(questionType.equals("Slider"))
		{
			String label = dataFormatter.formatCellValue(row.getCell(1));;
			String labelValue = dataFormatter.formatCellValue(row.getCell(2));
			slider.put(label, labelValue);
		}
		else
		if(questionType.equals("DynamicSlider"))
		{
			String label = dataFormatter.formatCellValue(row.getCell(1));;
			String labelValue = dataFormatter.formatCellValue(row.getCell(2));
			dynamicSlider.put(label, labelValue);
		}
		else
			if(questionType.equals("InfoPanel"))
			{
				String label = dataFormatter.formatCellValue(row.getCell(1));;
				String labelValue = dataFormatter.formatCellValue(row.getCell(2));
				infoPanel.put(label, labelValue);
			}
			else
				if(questionType.equals("MultipleChoice_radioBtn"))
				{
					String label = dataFormatter.formatCellValue(row.getCell(1));;
					String labelValue = dataFormatter.formatCellValue(row.getCell(2));
					multipleChoiceRadioBtn.put(label, labelValue);
				}	
	}
	
	values.put("Slider", slider);
	values.put("DynamicSlider", dynamicSlider);
	values.put("InfoPanel", infoPanel);
	values.put("MultipleChoice_radioBtn", multipleChoiceRadioBtn);
	
	return values;
	
	}	
}
