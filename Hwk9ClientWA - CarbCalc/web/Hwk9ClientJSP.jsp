<%-- 
    Document   : Hwk9ClientJSP
    Created on : Oct 7, 2015, 3:32:17 PM
    Author     : Raigeki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hwk9</title>
    </head>
    <body>
        <h1>Hwk9</h1>
            <%-- start web service invocation --%><hr/>
    <%
    try {
	hwk9serverpackage.Hwk9ServerWS_Service service = new hwk9serverpackage.Hwk9ServerWS_Service();
	hwk9serverpackage.Hwk9ServerWS port = service.getHwk9ServerWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String product = request.getParameter("selectname");
	java.lang.String sugar = "";
	java.lang.String carb = "";
	// TODO process result here
	java.lang.String result = port.operation(product, sugar, carb);
	out.println(result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
