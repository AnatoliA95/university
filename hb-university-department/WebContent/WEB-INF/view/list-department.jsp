<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List departments</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>University Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Department"
				   onclick="window.location.href='showFormForAddDepartment'; return false;"
				   class="add-button"
			/>
			<input type="button" value="Add Student"
				   onclick="window.location.href='showFormForAddStudent'; return false;"
				   class="add-button"
			/>
			<input type="button" value="Add Teacher"
				   onclick="window.location.href='showFormForAddTeacher'; return false;"
				   class="add-button"
			/>
			<input type="button" value="Add Course"
				   onclick="window.location.href='showFormForAddCourse'; return false;"
				   class="add-button"
			/>
			
			<!--  add our html table here -->
		<br><br>
		
			<table>
			
			<caption>Departments: </caption>
				<tr>
					<th>Name</th>
					<th>Budget</th>
				</tr>
				
				<!-- loop over and print our departments -->
				<c:forEach var="tempDepartment" items="${departments}">
				
					<!-- construct an "update" link with department id -->
					<c:url var="updateLink" value="/university/showFormForUpdateDepartment">
						<c:param name="departmentId" value="${tempDepartment.id}" />
					</c:url>	
					
					<!-- construct an "delete" link with department id -->
					<c:url var="deleteLink" value="/university/deleteDepartment">
						<c:param name="departmentId" value="${tempDepartment.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempDepartment.name} </td>
						<td> ${tempDepartment.budget} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this'))) return false;">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			<br><br>
		
			<table>
			
			<caption>Students: </caption>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Adress</th>
					<th>Speciality</th>
					<th>Department</th>
				</tr>
				
				<!-- loop over and print our students -->
				<c:forEach var="tempStudent" items="${students}">
				
					<!-- construct an "update" link with student id -->
					<c:url var="updateLink" value="/university/showFormForUpdateStudent">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>	
					
					<!-- construct an "delete" link with student id -->
					<c:url var="deleteLink" value="/university/deleteStudent">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.adress} </td>
						<td> ${tempStudent.speciality} </td>
						<td> ${tempStudent.department.name} </td>
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this'))) return false;">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			<br><br>
		
			<table>
			
			<caption>Teachers: </caption>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Salary</th>
					<th>Department</th>
				</tr>
				
				<!-- loop over and print our teachers -->
				<c:forEach var="tempTeacher" items="${teachers}">
				
					<!-- construct an "update" link with teacher id -->
					<c:url var="updateLink" value="/university/showFormForUpdateTeacher">
						<c:param name="teacherId" value="${tempTeacher.id}" />
					</c:url>	
					
					<!-- construct an "delete" link with teacher id -->
					<c:url var="deleteLink" value="/university/deleteTeacher">
						<c:param name="teacherId" value="${tempTeacher.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempTeacher.firstName} </td>
						<td> ${tempTeacher.lastName} </td>
						<td> ${tempTeacher.email} </td>
						<td> ${tempTeacher.salary} </td>
						<td> ${tempTeacher.department.name} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this'))) return false;">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			
			<br><br>
		
			<table>
			
			<caption>Courses: </caption>
				<tr>
					<th>Topic</th>
					<th>Teacher</th>
				</tr>
				
				<!-- loop over and print our courses -->
				<c:forEach var="tempCourse" items="${courses}">
				
					<!-- construct an "update" link with courses id -->
					<c:url var="updateLink" value="/university/showFormForUpdateCourse">
						<c:param name="courseId" value="${tempCourse.id}" />
					</c:url>	
					
					<!-- construct an "delete" link with courses id -->
					<c:url var="deleteLink" value="/university/deleteCourse">
						<c:param name="courseId" value="${tempCourse.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCourse.topic} </td>
						<td> ${tempCourse.teacher.firstName} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this'))) return false;">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
