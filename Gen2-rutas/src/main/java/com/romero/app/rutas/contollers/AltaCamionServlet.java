package com.romero.app.rutas.contollers;

import com.romero.app.rutas.ENUMS.Marcas;
import com.romero.app.rutas.ENUMS.TiposCamion;
import com.romero.app.rutas.models.Camion;
import com.romero.app.rutas.services.CamionesService;
import com.romero.app.rutas.services.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

@WebServlet("/camiones/alta")
public class AltaCamionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TiposCamion> listaTiposCamion = Arrays.asList(TiposCamion.values());
        List<Marcas> listaMarcas = Arrays.asList(Marcas.values());

        req.setAttribute("tipoCamion", listaTiposCamion);
        req.setAttribute("marcasCamion", listaMarcas);
        req.setAttribute("anios",listYears());

        getServletContext().getRequestDispatcher("/altaCamiones.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Camion> service = new CamionesService(conn);



        String  matricula   = req.getParameter("matricula");
        String  tipoCamion  = req.getParameter("tipoCamion");
        String  marca       = req.getParameter("marca");
        String  modelo      = req.getParameter("modelo");
        String  capacidad   = req.getParameter("capacidad");
        String  kilometraje = req.getParameter("kilometraje");
        Boolean habilitar;
        String[] checkbox;
        checkbox = req.getParameterValues("disponibilidad");


        if(checkbox!=null){
            habilitar = true;
        }
        else{
            habilitar = false;
        }
        Map<String,String> errores = new HashMap<>();
        if(matricula == null || matricula.equals("")){
            errores.put("nombre","la matricula es requerido!");
        }
        if(tipoCamion == null || tipoCamion.equals("")){
            errores.put("tipoCamion","el tipoCamion es requerido!");
        }
        if(marca == null || marca.equals("")){
            errores.put("marca","la marca materno es requerido!");
        }
        if(modelo == null || modelo.equals("")){
            errores.put("modelo","el modelo es requerida!");
        }
        if(capacidad == null || capacidad.equals("")){
            errores.put("capacidad","la capacidad es requerido!");
        }

        if(errores.isEmpty()){

            Camion camion = new Camion(
                    0L,
                    matricula,
                    tipoCamion,
                    marca,
                    Long.parseLong(modelo),
                    Integer.parseInt(capacidad),
                    Float.parseFloat(kilometraje),
                    habilitar
            );
            service.guardar(camion);
            resp.sendRedirect(req.getContextPath()+"/camiones/listar");

        }
        else{
            req.setAttribute("erroes",errores);
            getServletContext().getRequestDispatcher("/altaCamiones.jsp").forward(req,resp);

        }
    }

    public static List<Integer> listYears(){
        int year = Calendar.getInstance().get(Calendar.YEAR);

        List<Integer> years = new ArrayList<>();

        for(int i=2004; i<= year+1;i++){
            years.add(i);
        }

        return  years;
    }
}
