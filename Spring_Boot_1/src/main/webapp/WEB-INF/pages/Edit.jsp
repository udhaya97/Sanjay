<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>

	<div align="center" class="table-responsive">

		<form:form action="Update" modelAttribute="users">
			<table class="table table-bordered table-sm"
				style="width: 50%; margin-left: 200px;">


				<tr>
					<th>Customer Id</th>
					<th>Username</th>
					<th>Password</th>
					<th>City</th>
					<th>Mobile Number</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
				<c:forEach var="list" items="${list}">
					<c:if test="${list.id==user.id}">
						<tr>
							<td>${list.id}</td>
							<td><form:input path="userName" value="${list.userName}" /></td>
							<td><form:input path="city" value="${list.city}" /></td>
							<td><form:input path="mobile" value="${list.mobile }" /></td>

							<%-- <td><a href="Update?id=${user.id}">Update</a><br></td> --%>
						
							<td><a href="Delete?id=${user.id}">Delete</a><br></td>
						</tr>
					</c:if>
					<c:if test="${list.id != user.id}">
						<tr>
							<td>${list.id}</td>
							<td>${list.userName}</td>
							<td>${list.city}</td>
							<td>${list.mobile }</td>

							<td><a href="edit?id=${list.id}">Edit</a></td>
							<td><a href="delete?id=${list.id}">Delete</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</form:form>
	</div>
</body>
</html>
