package com.chitra.kms.controller.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.kms.entity.Student;
import com.chitra.kms.entity.User;
import com.chitra.kms.service.StudentService;
import com.chitra.kms.service.UserService;
import com.chitra.kms.utils.SSOIdUtil;

@RestController
@RequestMapping("/dashboard")
public class StudentRestController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	UserService userService;
	
	
	SSOIdUtil sSOIdUtil;
	HSSFWorkbook workbook;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllStudnet(@RequestParam("lang") String language,
											@RequestParam("searchName") String searchName,
											@RequestParam("numberOfRecord") int numberOfRecord,
											@RequestParam("pageCount") int pageCount){
		//Blank workbook
	       // HSSFWorkbook workbook = new HSSFWorkbook();
			workbook = new HSSFWorkbook();
	         
	        //Create a blank sheet
	        HSSFSheet sheet = workbook.createSheet("Employee Data");
	          
	      
		int offset = (pageCount-1)*numberOfRecord;
		
		String firstName = "";
		String lastName = "";
		if(language.equalsIgnoreCase("km")){
			firstName = "student.kmFirstName";
			lastName = "student.kmLastName";
		}else{
			firstName = "student.firstName";
			lastName = "student.lastName";
		}
		
		sSOIdUtil = new SSOIdUtil();		
		User user = userService.findBySso(sSOIdUtil.getPrincipal());
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Student> students =  studentService.findAll(user.getId(), firstName, lastName, searchName, numberOfRecord, offset);
		
		long recordTotal = studentService.countRecordListl(user.getId(), firstName, lastName, searchName);
		
		if(students == null){
             map.put("List", null);     
		}else{
			map.put("RecordTotal", recordTotal);
			map.put("List", students);
			
		}
		
		
		
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
		return map;
		
		
	}
	/**
	 * Retrive single student********************************************************************************************************
	 * @param id
	 * @return
	 */
	   @RequestMapping(value = "/student/{stu_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Map<String, Object> getStudent(@PathVariable("stu_id") int id) {
	        System.out.println("Fetching Student with id " + id);
	        Student student = studentService.findById(id);
	        Map<String, Object> map = new HashMap<String, Object>();
	        if (student == null) {
	            map.put("List", "NOT FOUND");
	            
	        }else{
	        	map.put("List", student);
	        	
	        }
	        return map;
	    
	}

}
