package com.romero.app.jpa.repository;

import com.romero.app.jpa.models.consultas.ConsultasCalificacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultasRepository {

    private Connection conn;

    private static String url ="jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "SYSTEM";
    private static String password = "root";

    public ConsultasRepository(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url,username,password);
            this.conn = conn;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public List<ConsultasCalificacion> calificacionesPor(Long id){
        List<ConsultasCalificacion> consultasCalificacions = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT a.ID_T_USUARIOS AS id_t_usuario, a.NOMBRE AS nombre_alumno, a.AP_PATERNO AS apellido_paterno_alumno, m.NOMBRE AS nombre_materia, c.CALIFICACION AS calificacion_materia, c.FECHA_REGISTRO FROM T_ALUMNOS a JOIN T_CALIFICACIONES c ON a.ID_T_USUARIOS = c.ID_T_USUARIOS JOIN T_MATERIAS m ON c.ID_T_MATERIAS = m.ID_T_MATERIAS WHERE a.ID_T_USUARIOS = "+id))
        {
            while (rs.next()){
                ConsultasCalificacion consultasCalificacion = this.vistaCalificacion(rs);
                consultasCalificacions.add(consultasCalificacion);
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return consultasCalificacions;
    }

    private ConsultasCalificacion vistaCalificacion(ResultSet rs) throws SQLException{

        ConsultasCalificacion vista = new ConsultasCalificacion();

        vista.setId_t_usuario(rs.getLong("ID_T_USUARIO"));
        vista.setNombre_alumno(rs.getString("NOMBRE_ALUMNO"));
        vista.setApellido_paterno_alumno(rs.getString("APELLIDO_PATERNO_ALUMNO"));
        vista.setNombre_materia(rs.getString("NOMBRE_MATERIA"));
        vista.setCalificacion_materia(rs.getFloat("CALIFICACION_MATERIA"));
        Date cadena = rs.getDate("FECHA_REGISTRO");
        //String cosa[] = cadena.toString().split("/");
        //String j = cosa[2]+"/"+cosa[1]+"/"+cosa[0]
        vista.setFecha_registro(cadena.toString());

        //v.setId(rs.getLong("ID_CAMION"));


        return vista;
    }

}
