<%-- 
    Document   : editarempleado
    Created on : 9/05/2022, 08:22:54 PM
    Author     : aly
--%>

<%@page import="modelo.empleados"%>
<%@page import="Controlador.AccionesEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="editarempleado">
            <form name="editar" method="post" action="actualizarempleado">
                <table border="2">
                    <%
                        
                    //id
                    int id= Integer.parseInt(request.getParameter("id"));
                    //empleado
                    empleados e= AccionesEmpleado.buscarEmpleadoID(id);
                    %>
                    <tr>
                        <td>ID</td>
                        <td><input type="hidden" 
                                   value="<%=e.getId()%>"></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" 
                                   value="<%=e.getNombre()%>"></td>
                    </tr>
                    <tr>
                        <td>Passsword</td>
                        <td><input type="password" 
                                   value="<%=e.getPassword()%>"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" 
                                   value="<%=e.getEmail()%>"></td>
                    </tr>
                    <tr>
                        <td>Pais:</td>
                        <td><input type="pais">
                            <select  name="pais">
                            <option>Mexico</option>
                            <option>India</option>
                            <option>Por ahi</option>
                            <option>Al que nadie quiere</option>
                        </select></td>
                    </tr>
                </table>
                
            </form>
        </div>
    </body>
</html>
