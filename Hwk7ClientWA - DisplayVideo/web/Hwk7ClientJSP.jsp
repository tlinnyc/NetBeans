<%-- 
    Document   : Hwk7ClientJSP
    Created on : Sep 26, 2015, 8:18:18 PM
    Author     : Tommy
--%>

<%@page import="javafx.scene.media.*"%>
<%@page import="java.io.RandomAccessFile"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hwk7: Display animal file</title>
    </head>
    <body>
        <h1>Hwk7: Display animal file</h1>
        
            <%-- start web service invocation --%><hr/>
    <%
    try {
	hwk7serverp.Hwk7ServerWS_Service service = new hwk7serverp.Hwk7ServerWS_Service();
	hwk7serverp.Hwk7ServerWS port = service.getHwk7ServerWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String animal = request.getParameter("animal");
	// TODO process result here
	java.lang.String result = port.hwk7Op(animal);
	out.println(result);
                
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
