<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Vozdra raja ovo je JSP page</h1>
<p>Danas je <%=LocalDateTime.now()%></p>

<%

    int slucajanBroj = new Random().nextInt(11);
    if(slucajanBroj>5){%><h3>Dobro jutro</h3>
<%}else{%> <h3>Kakvo crno jutro smrklo je odvano</h3>
<%}%>





</body>
</html>
