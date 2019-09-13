<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Save Course:</title>
</head>
<body>
	<h2>University Relationship Manager</h2>
		<h3>Save course</h3>
		<form:form action="saveCourse" modelAttribute="course" method="POST">
		<!--  need to associate this data with student id -->
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>Topic:</label></td>
					<td><form:input path="topic"/></td>
				</tr>
				<tr>
					<td><label>Teacher:</label></td>
					<td><form:select path="temporary"  >
					<c:forEach var="tempTeacher" items="${teachers}">
					<form:option value="${tempTeacher.id}" label="${tempTeacher.firstName}"/>
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