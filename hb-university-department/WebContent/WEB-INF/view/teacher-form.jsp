<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Save Teacher:</title>
</head>
<body>
	<h2>University Relationship Manager</h2>
		<h3>Save student</h3>
		<form:form action="saveTeacher" modelAttribute="teacher" method="POST">
		<!--  need to associate this data with student id -->
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><label>Salary:</label></td>
					<td><form:input path="salary"/></td>
				</tr>
				<tr>
					<td><label>Department:</label></td>
					<td><form:select path="temporary"  >
					<c:forEach var="tempDepartment" items="${departments}">
					<form:option value="${tempDepartment.id}" label="${tempDepartment.name}"/>
					</c:forEach>
					</form:select></td>
				</tr>
				
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>
			</tbody>
		</table>
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/university/department">Back to menu </a>
		</p>
	</div>
</body>
</html>