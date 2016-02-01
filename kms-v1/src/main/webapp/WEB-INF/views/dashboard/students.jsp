<template:basic htmlTitle="Students" bodyTitle="Students">
	<!-- Modal -->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <form id="student-form">
	      	<fieldset>
	      		<legend>ព័ត៏មានអំពីសិស្ស៖</legend>	      		
		      	<div class="col-sm-12 ">
		      		<div class="col-sm-6 form-group">
			      		<label for="kmLastName" class="col-sm-5 control-label">នាមត្រកូល៖</label>
			      		<div class="col-sm-7">
			      			<input type="text" id="kmLastName" name="kmLastName" class="form-control" >
			      		</div>	
		      		</div>	
		      		<div class="col-sm-6 form-group">
			      		<label for="lastName" class="col-sm-5 control-label">ជាភាសាអង់គ្លេស៖</label>
			      		<div class="col-sm-7">
			      			<input type="text" id="lastName" name="lastName" class="form-control" >
			      		</div>	
		      		</div>	      		
		      	</div>      		
		      	<div class="col-sm-12 ">
		      		<div class="col-sm-6 form-group">
			      		<label for="kmFirstName" class="col-sm-5 control-label">នាមខ្លួន៖</label>
			      		<div class="col-sm-7">
			      			<input id="kmFirstName" type="text" name="kmFirstName" class="form-control" >
			      		</div>	
		      		</div>	
		      		<div class="col-sm-6 form-group">
			      		<label for="firstName" class="col-sm-5 control-label">ជាភាសាអង់គ្លេស៖</label>
			      		<div class="col-sm-7">
			      			<input id="firstName" type="text" name="firstName" class="form-control" >
			      		</div>	
		      		</div>	      		
		      	</div> 
	      		<div class="col-sm-12">
                	<div class="col-sm-6 form-group">
                		<label for="gender" class="col-sm-5 control-label">ភេទ៖</label>
                		<div class="col-sm-7" id="selectionGender">
                			<select id="gender"  class="form-control">
                				<option value="M">ប្រុស</option>							                				
                				<option value="F">ស្រី</option>
                			</select>						                			
                		</div>
                	</div> 
                	<div class="col-sm-6 form-group">
                		<label for="birthDate" class="col-sm-5 control-label">ថ្ងៃ ខែ ឆ្នាំ កំណើត(yyyy-mm-dd)៖</label>
                		<div class="col-sm-7">                			
                			<input type="text"  id="dateOfBirth" class="form-control" >
                		</div>
                	</div>
	      		</div>
	      		      		
		      	<div class="col-sm-12 ">
		      		<div class="col-sm-6 form-group">
			      		<label for="nationality" class="col-sm-5 control-label">សញ្ជាតិ៖</label>
			      		<div class="col-sm-7">
			      			<input id="nationality" type="text" class="form-control" >
			      		</div>	
		      		</div>	
		      		<div class="col-sm-6 form-group">
			      		<label class="col-sm-5 control-label">ជាភាសាអង់គ្លេស៖</label>
			      		<div class="col-sm-7">
			      			<input type="text" class="form-control" >
			      		</div>	
		      		</div>	      		
		      	</div> 
		      	<legend>អាសយដ្ឋាន</legend>
		      	<div class="col-sm-12">
		      		<div class="col-sm-6 form-group">
		      			<label for="city" class="col-sm-5 control-label">ក្រុង/រាជធានី</label>
		      			<div class="col-sm-7">
		      				<select id="gender" class="form-control">
	               				<option value="pnp">ភ្នំពេញ</option>							                				
	               				<option value="knd">កណ្តាល</option>
	               			</select>
		      			</div>
		      		</div>
		      		<div class="col-sm-6 form-group">
		      			<label for="city" class="col-sm-5 control-label">ខ័ណ្ឌ/ស្រុក</label>
		      			<div class="col-sm-7">
		      				<select id="gender" class="form-control">
	               				<option value="psc">ពោធិសែនជ័យ</option>							                				
	               				<option value="dgk">ដង្កោ</option>
	               			</select>
		      			</div>
		      		</div>
		      	</div>
		      	<div class="col-sm-12">
		      		<div class="col-sm-6 form-group">
		      			<label for="city" class="col-sm-5 control-label">សង្កាត់/ឃុំ</label>
		      			<div class="col-sm-7">
		      				<select id="gender" class="form-control">
	               				<option value="pnp">ភ្នំពេញ</option>							                				
	               				<option value="knd">កណ្តាល</option>
	               			</select>
		      			</div>
		      		</div>
		      		<div class="col-sm-6 form-group">
		      			<label for="city" class="col-sm-5 control-label">ភូមិ</label>
		      			<div class="col-sm-7">
		      				<select id="gender" class="form-control">
	               				<option value="psc">ព្រៃកំបុត</option>							                				
	               				<option value="dgk">ព្រៃកី(ក)</option>						                				
	               				<option value="dgk">ព្រៃកី(ខ)</option>						                				
	               				<option value="dgk">ព្រៃកី(គ)</option>						                				
	               				<option value="dgk">ស្រែញរ</option>
	               			</select>
		      			</div>
		      		</div>
			      	<div class="col-sm-12">
			      		<div class="col-sm-6 form-group">
			      			<label for="city" class="col-sm-5 control-label">ផ្ទះលេខ</label>
			      			<div class="col-sm-7">
			      				<select id="gender" class="form-control">
		               				<option value="pnp">ភ្នំពេញ</option>							                				
		               				<option value="knd">កណ្តាល</option>
		               			</select>
			      			</div>
			      		</div>
			      		<div class="col-sm-6 form-group">
			      			<label for="city" class="col-sm-5 control-label">ផ្លូវលេខ</label>
			      			<div class="col-sm-7">
			      				<select id="gender" class="form-control">
		               				<option value="psc">ពោធិសែនជ័យ</option>							                				
		               				<option value="dgk">ដង្កោ</option>
		               			</select>
			      			</div>
			      		</div>
			      	</div>
			      	</div>
			      	<legend>ទំនាក់ទំនង</legend>   		
			      	<div class="col-sm-12 ">
			      		<div class="col-sm-6 form-group">
				      		<label for="kmLastName" class="col-sm-5 control-label">លេខទូរស័ព្ទ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="kmLastName" name="kmLastName" class="form-control" >
				      		</div>	
			      		</div>	
			      		<div class="col-sm-6 form-group">
				      		<label for="lastName" class="col-sm-5 control-label">សារអេឡិចត្រូនិច៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="lastName" class="form-control" >
				      		</div>	
			      		</div>	      		
			      	</div>
			      	<legend>គ្រួសារ</legend>   		
			      	<div class="col-sm-12 ">
			      		<div class="col-sm-4 form-group">
				      		<label for="kmLastName" class="col-sm-5 control-label">ឳពុកឈ្មោះ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="kmLastName" name="kmLastName" class="form-control" >
				      		</div>	
			      		</div>	
			      		<div class="col-sm-4 form-group">
				      		<label for="lastName" class="col-sm-5 control-label">មុខរបរ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="lastName" class="form-control" >
				      		</div>	
			      		</div>	
			      		<div class="col-sm-4 form-group">
				      		<label for="lastName" class="col-sm-5 control-label">លេខទូរស័ព្ទ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="lastName" class="form-control" >
				      		</div>	
			      		</div>		      		
			      	</div>   		
			      	<div class="col-sm-12 ">
			      		<div class="col-sm-4 form-group">
				      		<label for="kmLastName" class="col-sm-5 control-label">ម្តាយឈ្មោះ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="kmLastName" name="kmLastName" class="form-control" >
				      		</div>	
			      		</div>	
			      		<div class="col-sm-4 form-group">
				      		<label for="lastName" class="col-sm-5 control-label">មុខរបរ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="lastName" class="form-control" >
				      		</div>	
			      		</div>	
			      		<div class="col-sm-4 form-group">
				      		<label for="lastName" class="col-sm-5 control-label">លេខទូរស័ព្ទ៖</label>
				      		<div class="col-sm-7">
				      			<input type="text" id="lastName" class="form-control" >
				      		</div>	
			      		</div>		      		
			      	</div>
				      	
		      	
		      	<input type="button" class="btn btn-info" id="btnAdd" value="Add" >
		      	
	      	</fieldset>
	      </form>
	    </div>
	  </div>
	</div>
	<!-- End Modal -->
	<c:forEach var="user" items="${user.userProfiles}">
       <c:if test="${user.type == 'DIRECTOR'}">
       </c:if>
 	</c:forEach> 
	

	<div class="row font-km">
      <div class="col-md-12">
          <div class="panel panel-default">
              <div class="panel-heading">
                  <h3 class="panel-title">បញ្ចីរាយនាមសិស្ស</h3>
              </div>
              <div class="panel-body">
                  <div class="row">
                  
                 	<!-- Open Modal -->
					<div class="pull-right btn-group-sm">
	                          <button type="button" id="add_student" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">ចុះឈ្មោះសិស្ស</button>
	                </div>
	                <!-- ******************************************************* -->
                  
                      <div class="col-md-12 col-sm-12 col-xs-12">
                     		<fieldset>
                     			<legend>ជម្រើសនៃការស្វែងរក</legend>
                     				<div class="row"> 
                     					<div class="col-sm-12">
                     						<div class="col-sm-6">
							                	<div class="form-group">
							                		<label class="col-sm-3 control-label">គ្រូបង្រៀន:</label>
							                		<div class="col-m3" id="selectionUser">						                			
							                		</div>
							                	</div>                     						
                     						</div>
                     						<div class="col-sm-6">
							                	<div class="form-group">
							                		<label class="col-sm-3 control-label">កំរិតសៀវភៅ</label>
							                		<div class="col-m3" id="selectionClassRoom">
							                			<select>
							                				<option>EIC1</option>							                				
							                				<option>EIC2</option>
							                			</select>						                			
							                		</div>
							                	</div>                     						
                     						</div>	
                     					
                     					</div>
                     					<div class="col-sm-12">                     					
							                <div class="col-md-8">						                	                    				   		
		                                        <div class="radio radio-info radio-inline">
		                                            <input type="radio" id="kmRadio" value="km" name="langRadio" checked>
		                                            <label for="kmRadio"> ភាសាខ្មែរ </label>
		                                        </div>
		                                        <div class="radio radio-info radio-inline">
		                                            <input type="radio" id="enRadio" value="en" name="langRadio">
		                                            <label for="enRadio"> English </label>
		                                        </div>
							                </div>
	                     				   <div class="col-md-8">                      				   		
		                                        <div class="input-group">
								                    <input type="text" id="searchName" name="example-input1-group2" class="form-control input-sm" placeholder="ស្វែងរកតាមរយៈឈ្មោះសិស្ស...">
								                    <span class="input-group-btn">
								                        <button id="btnSearchName" type="button" class="btn-sm btn waves-effect waves-light btn-primary w-md"><i class="fa fa-search"></i></button>
								                    </span>
								                </div>
	                     				   </div>
	                     				   <div class="alert alert-info">
	                     				   		<p id="messageTyping"></p>                     				   	
	                     				   <br/><br/>
										   </div>
                     					
                     					</div>
                     				</div>
                     		</fieldset>
                     	
                          <table class="table table-hover table-striped table-bordered" id="tb_student">
                              <thead>
                              </thead>
                              <tbody>
                              </tbody>
                              <tfoot>
                              </tfoot>
                              
                          </table>
                          	<nav id="pagination">
							</nav>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="col-md-6" id="stu_infor_details" style="display:none">
      	<div class="panel">
              <div class="panel-body">
                  <div class="media-main">
                      <a class="pull-left" href="#">
                          <img class="thumb-lg img-circle" src="<c:url value="/static/images/users/avatar-2.jpg" />" alt="">
                      </a>
                      <div class="pull-right btn-group-sm">
                          <a href="#" class="btn btn-success waves-effect waves-light tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Edit">
                              <i class="fa fa-pencil"></i>
                          </a>
                          <a href="#" class="btn btn-danger waves-effect waves-light tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Delete">
                              <i class="fa fa-close"></i>
                          </a>
                      </div>
                      <div class="info">
                          <h4 id="info_full_name">Chitra Sem (Chitra Sem)</h4>
                          <p class="text-muted">Student</p>
                          <fieldset class="text-muted" >
                          	<legend class="text-muted">ពត៏មាន ផ្ទាល់ខ្លួន</legend>
                          	<div class="form-group">
	                          	<label class="control-label col-sm-4">ថ្ងៃ/ខែ/ឆ្នាំ កំណើត:</label>
	                          	<label class="col-sm-8" id="info_birth_date">2015/01/12<span class="អាយុ"> (១ ឆ្នាំ)</span></label>
	                        </div>
	                        <div class="form-group">
	                          	<label class="control-label col-sm-4">ភេទ:</label>
	                          	<label class="col-sm-8" id="info_gender">ប្រុស</label>
	                        </div>
	                        <div class="group">
	                          	<label class="control-label col-sm-4 text-muted">សញ្ចាតិ:</label>
	                          	<label class="col-sm-8" id="info_nationality">Cambodian</label>
	                        </div> 
	                        <div class="group">
	                          	<label class="control-label col-sm-4 text-muted">Marital status:</label>
	                          	<label class="col-sm-8" id="info_maritalstatus">Single</label>
	                        </div>            
	                        <legend class="text-muted">ទំនាក់ទំនង ពត៏មាន</legend>
                        	<div class="group">
	                          	<label class="control-label col-sm-4 text-muted">Phone number:</label>
	                          	<label class="col-sm-8" id="info_phoneNumber">086-457-324</label>
                          	</div>
                        	<div class="group">
	                          	<label class="control-label col-sm-4 text-muted">Email Address:</label>
	                          	<label class="col-sm-8" id="info_emailaddress">sabaychitra84@gmail.com</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Home Address:</label>
	                          	<label class="col-sm-8" id="info_currentAddressr">Prey Kombot, Chom Choa, Porsenchey, Phnom Penh</label>
                          	</div>  
	                        <legend class="text-muted">ពត៏មានអំពី ឳពុក ម្តាយ​​​</legend>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Father's name:</label>
	                          	<label class="col-sm-8" id="info_fatherName">Sem Sokleang</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Father's phone:</label>
	                          	<label class="col-sm-8" id="info_fatherPhone">012-286-944</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Mohter's name:</label>
	                          	<label class="col-sm-8" id="info_motherName">Poa Tol</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Mother's phone:</label>
	                          	<label class="col-sm-8" id="info_motherPhone">012-286-944</label>
                          	</div>
	                        <legend>Contact Information</legend>             
                          </fieldset>
                      </div>
                  </div>
                  <div class="clearfix"></div>
                  <hr/>
                  <ul class="social-links list-inline">
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="LinkedIn"><i class="fa fa-linkedin"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Message"><i class="fa fa-envelope-o"></i></a>
                      </li>
                  </ul>
              </div> <!-- panel-body -->
          </div> <!-- panel -->
      </div>
  </div> <!-- End Row -->
	
      <script src="<c:url value='/static/kms/js/student.js' />"></script>
</template:basic>
