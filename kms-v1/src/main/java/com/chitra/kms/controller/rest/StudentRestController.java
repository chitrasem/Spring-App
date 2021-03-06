package com.chitra.kms.controller.rest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.chitra.kms.entity.Student;
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
	@RequestMapping(value="/student/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> addStudent(@RequestBody() Student student){		
		System.out.println(student.getFirstName());
		System.out.println(student.getDateOfBirth());	
		
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			studentService.save(student);			
			map.put("SUCCESS", true);
			map.put("MESSAGE", student.getFirstName() +" has been added successfully");
		}catch(Exception e){
			map.put("SUCCESS", false);
			map.put("ERROR", e.getStackTrace());
		}		
		return map;
	}
	@RequestMapping(value = "/student", method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllStudnet(@RequestParam("lang") String language,
											@RequestParam("searchName") String searchName,
											@RequestParam("whereUser") int whereUserId,
											@RequestParam("numberOfRecord") int numberOfRecord,
											@RequestParam("pageCount") int pageCount){	          
		
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
		//User user = userService.findBySso(sSOIdUtil.getPrincipal());
		Map<String, Object> map = new HashMap<String, Object>();		
		List<Student> students =  studentService.findAll(
				firstName, 
				lastName, 
				searchName, 
				whereUserId,
				numberOfRecord, 
				offset);		
		long recordTotal = studentService.countRecordListl(
				firstName, 
				lastName, 
				searchName,
				whereUserId);		
		if(students == null){
             map.put("List", null);     
		}else{
			map.put("RecordTotal", recordTotal);
			map.put("List", students);		
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
