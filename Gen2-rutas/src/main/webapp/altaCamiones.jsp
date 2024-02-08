<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@ page import="com.romero.app.rutas.ENUMS.*" %>


<%
    Map<String,String>errores = (Map<String,String>)request.getAttribute("errores");
    List<TiposCamion> listaTiposCamion =  (List<TiposCamion>) request.getAttribute("tipoCamion");
    List<Marcas> listaMarcas = (List<Marcas>) request.getAttribute("marcasCamion");

%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Choferes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
           integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
           crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" id="div1">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" id="enlace1">Rutas App</a>
            </div>




            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Choferes<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/choferes/listar">Lista Choferes</a></li>
                            <li><a href="<%=request.getContextPath()%>/choferes/alta">Alta Chofer</a></li>


                        </ul>


                    </li>


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Camiones<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/camiones/listar">Lista Camiones</a></li>
                            <li><a href="<%=request.getContextPath()%>/camiones/alta">Alta Camion</a></li>


                        </ul>
                    </li>


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Rutas<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/rutas/alta">Alta Ruta</a></li>


                        </ul>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
      </nav>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Formulario alta Camion</h2>
            </div>
        </div>
        <br>
        <% if(errores != null && errores.size()>0){ %>
            <ul class="alert alert-danger mx-5 px-5">
                <% for(String error:errores.values()){%>
                    <li><%=error%></li>
                <% } %>
            </ul>
        <%}%>
        <!---->
        <div class="row">
            <form action="<%=request.getContextPath()%>/camiones/alta" method="post">
                <div class="col-md-12">
                    <!--1-->
                    <div class="form-group">
                        <label for="">matricula</label>
                        <input type="text" name="matricula" id="matricula" class="form-control" value="${param.matricula}">

                            <%
                                if(errores != null && errores.containsKey("matricula")){
                                    out.println("<span class='text-danger'>"+errores.get("matricula")+"</span>");
                                }
                             %>

                    </div>
                    <!--2-->
                    <div class="form-group">
                        <label for="">Tipo Camion</label>
                         <select name="tipoCamion" id="tipoCamion" class="form-control">
                            <option value="">-- Seleccionar --</option>
                            <% for(TiposCamion tipoCamion: listaTiposCamion ){ %>
                                <option value="<%=tipoCamion%>"><%=tipoCamion%></option>
                                <%
                                    if(errores != null && errores.containsKey("tipoCamion")){
                                        out.println("<span class='text-danger'>"+errores.get("tipoCamion")+"</span>");
                                    }
                                %>

                            <% } %>
                        </select>

                    </div>
                    <!--3-->
                    <div class="form-group">
                        <label for="">Marca</label>

                        <select name="marca" id="marca" class="form-control">
                            <option value="">-- Seleccionar --</option>
                            <% for(Marcas marca: listaMarcas  ){ %>
                                <option value="<%= marca %>"><%=marca%></option>
                                <%
                                    if(errores != null && errores.containsKey("marca")){
                                        out.println("<span class='text-danger'>"+errores.get("marca")+"</span>");
                                    }
                                %>

                            <% } %>
                        </select>

                    </div>
                    <!--4-->
                    <div class="form-group">
                         <label for="">Modelo</label>
                          <select name="modelo" id="modelo" class="form-control">
                                 <option value="">-- Seleccionar --</option>
                                 <% for (Integer year : (List<Integer>) request.getAttribute("anios")) { %>
                                     <option value="<%= year %>"><%= year %></option>
                                 <% } %>
                          </select>
                         <%
                             if(errores != null && errores.containsKey("anio")){
                                 out.println("<span class='text-danger'>"+errores.get("anio")+"</span>");
                             }
                         %>
                    </div>
                    <!--5-->
                    <div class="form-group">
                        <label for="">Capacidad</label>
                        <input type="text" name="capacidad" id="capacidad" class="form-control" value="${param.capacidad}">
                        <%
                            if(errores != null && errores.containsKey("capacidad")){
                                out.println("<span class='text-danger'>"+errores.get("capacidad")+"</span>");
                            }
                        %>
                    </div>
                    <!--6-->
                    <div class="form-group">
                        <label for="">Kilometraje</label>
                        <input type="text" name="kilometraje" id="kilometraje" class="form-control" value="${param.kilometraje}">
                        <%
                            if(errores != null && errores.containsKey("kilometraje")){
                                out.println("<span class='text-danger'>"+errores.get("kilometraje")+"</span>");
                            }
                        %>
                    </div>
                    <!--7-->
                    <div class="form-group">
                        <label for="">Disponibilidad</label>
                        <input type="checkbox" name="disponibilidad" id="disponibilidad" class="form-check-input" value="${param.disponibilidad}" checked>
                    </div>
                    <!--8-->
                    <div class="form-group">
                       <button type="submit" class="btn btn-success">Gurdar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>

</html>