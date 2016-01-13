package com.chitra.kms;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CreateWorkBook {
	
	public static void main(String[] args) throws IOException {
		/*String dirPath = "E:/test.xls";
		
		FileOutputStream fout = new FileOutputStream(dirPath);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		HSSFSheet sheet = workbook.createSheet("Hello");
		
		HSSFRow row = sheet.createRow((short) 0);
		
		HSSFCell cell ;
		
		cell = row.createCell(0);
		cell.setCellValue(new HSSFRichTextString("HelloMe"));
		
		cell = row.createCell(1);
		cell.setCellValue(new HSSFRichTextString("Hell1"));
		
		workbook.write(outputStream);
		outputStream.writeTo(fout);
		outputStream.close();
		fout.close();*/
		
		//Blank workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
         
        //Create a blank sheet
        HSSFSheet sheet = workbook.createSheet("Employee Data");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("E:/howtodoinjava_demo.xls"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
	}

}
