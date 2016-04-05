<%-- 
    Document   : Hwk10ClientJSP
    Created on : Oct 11, 2015, 1:54:28 PM
    Author     : Raigeki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hwk10</title>
    </head>
    <body>
        <h1>Hwk10</h1>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	hwk10serverpackage.Hwk10ServerWS_Service service = new hwk10serverpackage.Hwk10ServerWS_Service();
	hwk10serverpackage.Hwk10ServerWS port = service.getHwk10ServerWSPort();
	 // TODO initialize WS operation arguments here
	int range = Integer.parseInt(request.getParameter("inputselect"));
	// TODO process result here
	java.util.List<java.lang.String> result = port.operation(range);
	out.println(result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
