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
import java.util.List;

@WebServlet("/choferes/listar")
public class ListaChoferesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recuperamos la onexion que provee el filtro
        Connection conn = (Connection) req.getAttribute("conn");
        //Declaramos un objeto de tipo Servicio

        IService< Chofer> service = new ChoferesService(conn);
        List<Chofer> choferes = service.listar();
        /*for(Chofer c:choferes){
            resp.getWriter().println("<h1>"+c.getId()+"->"
                +c.getNombre()+" -> "+c.getApPaterno()+"</h1>"
            );
        }*/
        req.setAttribute("choferes",choferes);
        getServletContext().getRequestDispatcher("/listaChoferes.jsp").forward(req,resp);
    }
}
