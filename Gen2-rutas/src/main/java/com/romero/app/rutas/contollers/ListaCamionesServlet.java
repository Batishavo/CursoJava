package com.romero.app.rutas.contollers;

import com.romero.app.rutas.models.Camion;
import com.romero.app.rutas.services.CamionesService;
import com.romero.app.rutas.services.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/camiones/listar")
public class ListaCamionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recuperamos la conexion que provve el filtro
        Connection conn = (Connection) req.getAttribute("conn");
        //Declaramos un objeto de tipo servicio

        IService<Camion> service = new CamionesService(conn);
        List<Camion> camiones = service.listar();
        /*for(Camion c:camiones){
            resp.getWriter().println(c.getMatricula());
        }*/
        req.setAttribute("camiones",camiones);
        getServletContext().getRequestDispatcher("/listaCamiones.jsp").forward(req,resp);
    }
}
