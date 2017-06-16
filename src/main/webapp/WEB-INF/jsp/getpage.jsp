<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Details</title>
</head>
<body>
<h1>Get Person</h1>

<c:if test="${empty person}">
	No records found!
</c:if>

<c:if test="${!empty person}">
	<table style="border: 1px solid #333">
		<tr>
		<td style="width: 100px">Id</td>
		<td>${person.id}</td>
		</tr>
		
		<tr>
		<td>Name</td>
		<td>${person.name}</td>
		</tr>
		
		<tr>
		<td>Last Name</td>
		<td>${person.age}</td>
		</tr>
		
		<tr>
		<td>Languages</td>
		<td>${person.languages}</td>
		</tr>
	</table>
</c:if>

</body>
</html>