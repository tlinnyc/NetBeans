<%-- 
    Document   : Hwk4JSP
    Created on : Sep 17, 2015, 1:18:07 PM
    Author     : Raigeki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	Hwk4ClientPackage.Hwk4ServerWS_Service service = new Hwk4ClientPackage.Hwk4ServerWS_Service();
	Hwk4ClientPackage.Hwk4ServerWS port = service.getHwk4ServerWSPort();
	 // TODO initialize WS operation arguments here
	int systolic = 70;
	int diastolic = 50;
	// TODO process result here
	java.lang.String result = port.hwk4BloodPressure(systolic, diastolic);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
