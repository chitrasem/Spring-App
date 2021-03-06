$(window).load(function(){
	//$("#stu_infor_details").display("none");	
	
});


var student_info = {};
var myRadio = $('input[name=langRadio]');
var checkedValue = myRadio.filter(':checked').val();
var totalRecord = 0;
var myData = {"numberOfRecord":10,		
		"pageCount":1,
		"lang":checkedValue,
		"searchName":"%",
		"whereUser": 0
		};
$(document).ready(function(){	
	$(".select2").select2({
		tages: "true",
        width: '100%',
		
	});
	
	// list all 
	user.list_teacher(true);
	
	student.list_all_students();
	
	$("input:radio[name='langRadio']").change(function(){
		if($(this).val()=="km"){
			myData['lang'] = "km";
			myData['pageCount'] = 1;
			sendMessage.clearMessage("#messageTyping");
			student.list_all_students();
		}else{
			myData['pageCount'] = 1;
			myData['lang'] = "en";
			sendMessage.clearMessage("#messageTyping");
			
			student.list_all_students();
		}
	});
	$("#btnSearchName").click(function(){
		var inputSearchName = $("#searchName").val();
		myData['pageCount'] = 1;
		myData['searchName'] = "%"+inputSearchName+"%";		
		student.list_all_students();
		
	});
	
	// Show modal adding form
	$("#add_student").click(function(){
		//student.add_student();
	});	
	// adding or updating students
	$("#show_new_student").click(function(){
		if($("#new-student-form").is(":visible")){		
			$("#new-student-form").hide(100);
		}else{
			$("#new-student-form").show(1000);			
		}
	});
	
	$("#btnAdd").click(function(){
		if($(this).val() == "Add"){
			//student.validate(this.form);
			//var formStudent = this.form;
			//alert(formStudent.kmLastName.value);			
			
			student_info['firstName']	= $("#firstName").val();
			student_info['lastName']	= $("#lastName").val();
			student_info['kmFirstName']	= $("#kmFirstName").val();
			student_info['kmLastName']	= $("#kmLastName").val();
			student_info['gender']		= $("#gender").val();
			student_info['nationality']	= $("#nationality").val();	
			//var  d = new Date($("#dateOfBirth").val());
			//student_info['dateOfBirth'] = d;
			student_info['dateOfBirth'] = $("#dateOfBirth").val();
			
			//console.log(student_info);
			student.add_student();
			
			
		//	student_info['dateOfBirth'] = toLocalDate(d);
			
			/*if(validateForm()){
				console.log(student_info['dateOfBirth']);
				//student.add_student();
			}*/
		}else{
			student.update_student();
		}
		
	});
	
	var typingTimer;
	var doneTypingInterval = 10;
	var finaldoneTypingInterval = 500;

	$("#searchName").keydown(function(){
		clearTimeout(typingTimer);
	    if ($('#searchName').val) {
	        typingTimer = setTimeout(function () {
	        	sendMessage.messageAlert("#messageTyping", "កំពុងតែស្វែងរក...");
	        }, doneTypingInterval);
	    }
	});
	$("#searchName").keyup(function(){
		 clearTimeout(typingTimer);
		    typingTimer = setTimeout(function () {
		    	var inputSearchName = $("#searchName").val();
		    	 myData['searchName'] = "%"+$('#searchName').val()+"%";
				sendMessage.clearMessage("#messageTyping");
				myData['pageCount'] = 1;
				student.list_all_students();
		        
		    }, finaldoneTypingInterval);
	});
	
	
	
	
});
var user = {
	list_teacher: function(areTeachers){
		var data = {"areTeachers": areTeachers};
		$.ajax({
			type: "GET",
			data: data,
			url: '../action/service/user/all',
			success: function(resp){
				if(resp["SUCCESS"]==true){
					createSelectUser.users(resp);
					// Select2
				    $(".select2").select2({
				    	tages: "true",
				        width: '40%',
				        
				    }).on("change", function(e){
				    	myData["whereUser"] = e.val;
				    	myData['pageCount'] = 1;
				    	student.list_all_students();
				    });
				}
			}
		});
	}	
};
var student ={
		add_student: function(){
			$.ajax({
				headers:{
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				type: 'POST',
				data: JSON.stringify(student_info),
				url: '../dashboard/student/add',
				success: function(resp){
					alert("Adding!");
					console.log(resp);
					student.list_all_students();
				}
				
			});
		},
		update_student: function(){
			alert("udated");
		}
		,
		list_all_students: function(){
			$.ajax({
				type: "GET",
				data: myData,
				url: "../dashboard/student",
				beforeSend: function(){
				},
				success: function(response){
					console.log(response);
					if(response["List"].length == 0){
						sendMessage.messageAlert("#messageTyping", "ពុំមានទិន្នន័យដែលលោកអ្នកចង់ស្វែងរកទេ!");
					}					
					totalRecord = response['RecordTotal'];
					createTable.allUser(response);
					
					//var stu_id = ($("#tb_student").find("input.stu_id").val());
					//student.list_student_by_id(stu_id);
					
					$("td a.stud_data").click(function(){
						var stu_id = $(this).parent().find("input.stu_id").val();
						student.list_student_by_id(stu_id);
					});
						
					
					
				},
				error: function(){
					alert("Error!"); 
					
				}
					
			});
		},
		list_student_by_id: function(stu_id){
			if(stu_id == null){				
				$("#stu_infor_details").hide();
			}else{
				$("#stu_infor_details").show();
				$.ajax({
					url:  "../dashboard/student/"+stu_id,
					type:"GET",
					data: myData,
					success: function(response){
						createTable.singleStudent(response);
					},
					error: function(){
						alert("Error!");
						
					}
				
				});
				
			}
			
		}	
		
};
var paging = {
		createPagination : function(totalRecord)
		{
			if(totalRecord==0){
				$("#pagination").html("");
			}else{
				var a = totalRecord % myData.numberOfRecord; // 5				
				var numberOfPaging = Math.floor(totalRecord / myData.numberOfRecord);
			
				if(a>0){			
					numberOfPaging += 1;			
				}
				var paging = "<ul class='pagination'>"+
								"<li class='pagePrevious disabled'><a href='javascript:' aria-label='Previous'>" +
									"<span aria-hidden='true'>&laquo;</span></a></li>";
				
				for(var i=1; i<(numberOfPaging+1);i++){
					if(i == myData.pageCount) {
						paging += "<li class='active'><a class='numberOfPage' href='javascript:'>"+i+"</a></li>";
						continue;
					}
					paging += "<li><a class='numberOfPage' href='javascript:'>"+i+"</a></li>";			
				}
				paging +='<li class="pageNext disabled"><a href="javascript:" aria-label="Next"><span aria-hidden="true">&laquo;</span></a></li>';
				paging += "</u>";			
				$("#pagination").html(paging);
				
				if(myData['pageCount'] == 1){
					$("ul.pagination li.pagePrevious").addClass("disabled");
				}else{
					$("ul.pagination li.pagePrevious").removeClass("disabled");
				}
				if(myData['pageCount'] == numberOfPaging){
					$("ul.pagination li.pageNext").addClass("disabled");
				}else{
					$("ul.pagination li.pageNext").removeClass("disabled");
				}		
				

				$("#pagination li a.numberOfPage").on("click", function(){ 
						myData['pageCount'] = Number($(this).text());
						student.list_all_students();
				});
				$("ul.pagination li.pagePrevious").on("click", function(){
					if(myData['pageCount'] == 1){
						return false;
					}else{
						myData['pageCount'] -= 1;
						student.list_all_students();
					}
				});
				$("ul.pagination li.pageNext").on("click", function(){
					if(numberOfPaging == myData['pageCount']){
						return false;
					}else{
						myData['pageCount'] += 1;
						student.list_all_students();
					}
				});
			}
			
		},
}
var createTable = {
		singleStudent: function(data){
			var stu_info = data['List'];
			if(stu_info.married == false){
				marital_status = "Signle";
			}else{
				marital_status = "Married";
			}
			
			$("#info_full_name").text(stu_info.kmLastName+" "+stu_info.kmFirstName+ " ("+stu_info.lastName+" "+
					stu_info.firstName +")");
			
			$("#info_birth_date").text(stu_info.dateOfBirth.dayOfMonth+"/"+
					stu_info.dateOfBirth.monthOfYear+"/"+
					stu_info.dateOfBirth.year +" ("+stu_info.dateOfBirth.year+") ");
			$("#info_gender").text(stu_info.gender);
			$("#info_nationality").text(stu_info.nationality);
			$("#info_maritalstatus").text(marital_status);
			$("#info_phoneNumber").text(stu_info.phoneNumber);
			$("#info_emailaddress").text(stu_info.emailaddress);
			$("#info_currentAddressr").text(stu_info.currentAddress);
			$("#info_fatherName").text(stu_info.parents.fatherName);
			$("#info_fatherPhone").text(stu_info.parents.fatherPhone);
			$("#info_motherName").text(stu_info.parents.motherName);
			$("#info_motherPhone").text(stu_info.parents.motherPhone);
			
		},
		allUser: function(data){
			var table = "<thead>" +
							"<tr>" +
								"<th>#</th>" +
								"<th>នាមត្រកូល និង នាមខ្លួន</th>" +
								"<th>ភេទ</th>" +
								"<th>ថ្ងៃ ខែ ឆ្នាំ កំណើត</th>" +
								"<th>លេខទូរស័ព្ទ</th>" +
								"<th>ចូលមើល</th>" +
							"</tr>" +
						"</thead>" +
						"<tbody>";
			var list = data['List'];
			for(i=0; i<list.length; i++){
				table+= "<tr>" +
							"<td>"+(i+1)+"</td>" +
							"<td>"+
								list[i].lastName+ " "+
								list[i].firstName+
							"</td>" +
							"<td>"+
								list[i].gender+"</td>" +
							"<td>"+
								list[i].dateOfBirth+
							"</td>" +
							"<td>"+
								list[i].phoneNumber+"</td>" +
							"<td><input class='stu_id' type='hidden' value='"+list[i].id+"' />"+
							"<a class='stud_data' title='View' href='javascript:' data-original-title='View'><i class='md md-pageview '></i></a></td>" +
						"</tr>";
				
			}
			table += "</tbody>";
			$("#tb_student").html(table);
			paging.createPagination(totalRecord);
			
			
		}
		
};
var sendMessage = {
		messageAlert: function(target,message){		
			$(target).text(message);
			
		},
		clearMessage: function(target){
			$(target).text("");
		}
}
var createSelectUser = {
		users: function(data){
			var userData = data['List'];
			var selectionOption = '<select class="select2">'
				+'<option value="'+Number(0)+'">All</option>';
			for(var i= 0; i< userData.length; i++){
				selectionOption += '<option value="'+Number(userData[i].id)+'">'+
				userData[i].firstName+ ' '+
				userData[i].lastName+
				'</option>';
			}				
			
			$("#selectionUser").html(selectionOption);
	        
		}
		
}
var validateForm = function(){
	var isValid = true;
	if(student_info['kmLastName']==""){
		$("#kmLastName").focus();
		isValid = false;
	}else if(student_info['lastName']==""){
		$("#lastName").focus();
		isValid = false;
	}else if(student_info['kmFirstName']==""){
		$("#kmFirstName").focus();
		isValid = false;
	}else if(student_info['firstName']==""){
		$("#firstName").focus();
		isValid = false;
	}else if(student_info['gender']==""){
		$("#gender").focus();
		isValid = false;
	}else if(student_info['dateOfBirth']==""){
		$("#dateOfBirth").focus();
		isValid = false;
	}else if(student_info['nationality']==""){
		$("#nationality").focus();
		isValid = false;
	}
	else{
		isValid = true;
	}
	return isValid;
	
}
function toLocalDate (inDate) {
	
    var date = new Date();
    date.setTime(inDate.valueOf() + 60000 * inDate.getTimezoneOffset());
    return date;
}
