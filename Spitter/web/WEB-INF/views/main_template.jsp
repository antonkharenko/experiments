<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spitter</title>
</head>
<body>
	<center>
	<table cellspacing = "15" width="800">
		<tr>
			<td colspan="2" align="left">
				<tiles:insertAttribute name="top" />
			</td>
		</tr>
		<tr>
			<td width="600" align="left">
				<tiles:insertAttribute name="content" />
			</td>
			<td width="200" align="center">
				<tiles:insertAttribute name="side" />
			</td>
		</tr>
	</table>
	</center>
</body>
</html>