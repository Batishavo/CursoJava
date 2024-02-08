package com.romero.app.rutas.contollers;

import com.romero.app.rutas.models.Chofer;
import com.romero.app.rutas.services.ChoferesService;
import com.romero.app.rutas.services.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/choferes/alta")
public class AltaChoverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaChofer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Chofer> service = new ChoferesService(conn);

        String nombre = req.getParameter("nombre");
        String apPaterno = req.getParameter("apPaterno");
        String apMaterno = req.getParameter("apMaterno");
        String licencia = req.getParameter("licencia");
        String telefono = req.getParameter("telefono");
        String fechaNacimiento = req.getParameter("fechaNacimiento");

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (DateTimeException e){
            fecha = null;
        }
        String[] checkbox;
        checkbox = req.getParameterValues("disponibilidad");
        Boolean habilitar;
        
        if(checkbox!=null){
            habilitar = true;
        }
        else{
            habilitar = false;
        }
        Map<String,String> errores = new HashMap<>();
        if(nombre == null || nombre.equals("")){
            errores.put("nombre","el nombre es requerido!");
        }
        if(apPaterno == null || apPaterno.equals("")){
            errores.put("apPaterno","el apellido paterno es requerido!");
        }
        if(apMaterno == null || apMaterno.equals("")){
            errores.put("apMaterno","el apellido materno es requerido!");
        }
        if(licencia == null || licencia.equals("")){
            errores.put("licencia","la licencia es requerida!");
        }
        if(telefono == null || telefono.equals("")){
            errores.put("telefoni","el telefono es requerido!");
        }
        if(fechaNacimiento == null || fechaNacimiento.equals("")){
            errores.put("fechaNacimiento","la fecha nacimiento es requerido!");
        }
        if(errores.isEmpty())
        {
            Chofer chofer = new Chofer();
            chofer.setId(0L);
            chofer.setNombre(nombre);
            chofer.setApPaterno(apPaterno);
            chofer.setApMaterno(apMaterno);
            chofer.setLicencia(licencia);
            chofer.setTelefono(telefono);
            chofer.setFechaNacimiento(fecha);
            chofer.setDisponivilidad(habilitar);
            service.guardar(chofer);
            resp.sendRedirect(req.getContextPath()+"/choferes/listar");
        }
        else{
            req.setAttribute("erroes",errores);
            getServletContext().getRequestDispatcher("/altaChofer.jsp").forward(req,resp);
        }
        
    }
}
