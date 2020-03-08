<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input</title>
</head>
<body>
<%
	String errorA="";
	if(request.getAttribute("errorA")!=null)
		errorA = (String)request.getAttribute("errorA");
	String errorB="";
	if(request.getAttribute("errorB")!=null)
		errorB = (String)request.getAttribute("errorB");
	String a;
	String b;
	int c;
	if(request.getAttribute("parametarA")!=null){
		a=(String)request.getAttribute("parametarA");
	}else{
		a="0";
	}
	if(request.getAttribute("parametarB")!=null){
		b=(String)request.getAttribute("parametarB");
	}else{
		b="0";
	}
	if(request.getAttribute("c")!=null){
		c=(Integer)request.getAttribute("c");
	}else{
		c=0;
	}
%>
	<form action='../WebMath/math' method='post'>
		First operand: <input type='text' id='a' name='a' value='<%=a%>'/> 
		<br/>
		<%=errorA%>
		<br/>
		Second operand: <input type='text' id='b' name='b' value='<%=b%>'/> 
		<br/>
		<%=errorB%>
		<br/>
		Result: <input type='text' id='c' name='c' value='<%=c%>'/> 
		<br/>
		<input type='submit' id='operation' name='operation' value='Plus'/>
		<input type='submit' id='operation' name='operation' value='Minus'/>
	</form>
</body>
</html>