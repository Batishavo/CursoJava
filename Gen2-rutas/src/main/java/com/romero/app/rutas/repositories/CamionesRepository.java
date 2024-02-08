package com.romero.app.rutas.repositories;

import com.romero.app.rutas.models.Camion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamionesRepository implements IRepository<Camion> {
    //atributos
    private Connection conn;

    //constructor
    public CamionesRepository(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Camion> listar() throws SQLException {
        List<Camion> camiones = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CAMIONES"))
        {
            while (rs.next()){
                Camion camion = this.getCamion(rs);
                camiones.add(camion);
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return camiones;
    }

    @Override
    public Camion getByID(Long id) throws SQLException {
        Camion camion = null;

        try (
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM camiones WHERE ID_camion = ?")
        ){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next()){
                    camion = this.getCamion(rs);
                }
            }
        }

        return camion;
    }

    @Override
    public void guardar(Camion camion) throws SQLException {
        String sql = "";
        if(camion.getId() != null && camion.getId()>0){
            sql =
                    "update camiones set" +
                    "capacidad       = ?," +
                    "disponibilidad  = ?, " +
                    "kilometraje     = ?" +
                    "matricula       = ?" +
                    "tipo_camion     = ?" +
                    "where id_camion = ?"
            ;
        }
        else {
            sql = "INSERT INTO " +
                    "camiones(" +
                        "CAPACIDAD, " +
                        "DISPONIBILIDAD," +
                        "KILOMETRAJE," +
                        "MATRICULA ,"+
                        "TIPO_CAMION,"+
                        "MARCA,"+
                        "MODELO,"+
                        "ID_CAMION"+
                    " )\n" +
                    "VALUES(" +
                        "?, " +
                        "?, " +
                        "?, " +
                        "?,"  +
                        "?, " +
                        "?, " +
                        "?, " +
                        "?  " +
                    ")"
            ;
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            if(camion.getId()!=null && camion.getId()>0){
                stmt.setInt(1,camion.getCapacidad());
                stmt.setInt(2,camion.getDisponibilidad()?1:0);
                stmt.setFloat(3,camion.getKilometraje());
                stmt.setString(4,camion.getMatricula());
                stmt.setString(5,camion.getTipoCamion());
                stmt.executeUpdate();
            }
            else{
                stmt.setInt(1,camion.getCapacidad());
                stmt.setInt(2,camion.getDisponibilidad()?1:0);
                stmt.setFloat(3,camion.getKilometraje());
                stmt.setString(4,camion.getMatricula());
                stmt.setString(5,camion.getTipoCamion());
                stmt.setString(6,camion.getMarca());
                stmt.setLong(7,camion.getModelo());
                stmt.setLong(8,camion.getId());
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from camiones where ID_camion = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }

    private Camion getCamion(ResultSet rs) throws SQLException{

        Camion camion = new Camion();

        camion.setId(rs.getLong("ID_CAMION"));
        camion.setMatricula(rs.getString("MATRICULA"));
        camion.setTipoCamion(rs.getString("TIPO_CAMION"));
        camion.setCapacidad(rs.getInt("CAPACIDAD"));
        camion.setKilometraje(rs.getFloat("KILOMETRAJE"));
        camion.setDisponibilidad(rs.getInt("DISPONIBILIDAD")==0?false:true);
        camion.setMarca(rs.getString("MARCA"));
        camion.setModelo(rs.getLong("MODELO"));

        return camion;
    }
}
