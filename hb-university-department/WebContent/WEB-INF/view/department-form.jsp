<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Save department:</title>
</head>
<body>
	<h2>University Relationship Manager</h2>
		<h3>Save department</h3>
		<form:form action="saveDepartment" modelAttribute="department" method="POST">
		<!--  need to associate this data with department id -->
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>name:</label></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td><label>budget:</label></td>
					<td><form:input path="budget"/></td>
				</tr>
				
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>
			</tbody>
		</table>
		</form:form>
		<p>
			<a href="${pageContext.request.contextPath}/university/department">Back to menu </a>
		</p>
</body>
</html>