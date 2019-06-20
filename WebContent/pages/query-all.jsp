<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="per.modal.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PLATFORM</title>
</head>
<body>
	<table>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
<%
	List<Platform>plats=(List)session.getAttribute("plats");
	if(plats!=null){
		for(Platform plat:plats){
%>
	
		
		
	
	
<%	
		}
	}
%>
	</table>
</body>
</html>