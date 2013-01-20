<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.wellsfargo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%
	String[] favoriteMusic = {"Zero 7", "Tahiti 80", "BT", "Frou Frou"}; 
	request.setAttribute("musicList", favoriteMusic); 
%>
 </head>
<body>

Host is: <%= request.getHeader("host") %> 
</br>
EL Stuff :
</br>
Host is: ${header.host} 
Method is: ${pageContext.request.method}
First song is: ${musicList[0]} 
email is: ${ initParam.Email} 
</br>
Use Bean Stuff :
</br>

<jsp:useBean id="Person" type= "com.wellsfargo.Person" class="com.wellsfargo.Employee" scope="request" />
<jsp:setProperty name = "Person" property = "*"/>

Person created by servlet: <jsp:getProperty name="Person" property="name" /> 

Person ( ID ) created by servlet: <jsp:getProperty name="Person" property="empID" /> 

<%-- 
<% if (request.getParameter("name") != null) { %> 
<jsp:forward page="HandleIt.jsp" /> 
<% } %> 
 --%>

<c:if test="${empty param.userName}" >
<jsp:forward page="HandleIt.jsp" />
</c:if>

</body>
</html>