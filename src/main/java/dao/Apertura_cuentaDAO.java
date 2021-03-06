/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Cuenta;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author DAW
 */
public class Apertura_cuentaDAO
{
    public int comprobar_cuenta_existente(String cu_ncu2)
    {
        long resultado = 0;
        DBConnection db = new DBConnection();
        List<Cuenta> lista = null;
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Cuenta>> h = new BeanListHandler<>(Cuenta.class);
            lista = qr.query(con, "select cu_ncu from cuentas where cu_ncu = ?", h, cu_ncu2);
            
            if (lista.size() > 0)
                {
                    resultado = 1;
                }
            
            
        } catch (Exception ex) {
            Logger.getLogger(Apertura_cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        
        return (int) resultado;
    }
    
    public List<Cliente> comprobar_dni_existente(String cu_dn1)
    {
        long resultado = 0;
        DBConnection db = new DBConnection();
        List<Cliente> lista = null;
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Cliente>> h = new BeanListHandler<>(Cliente.class);
            lista = qr.query(con, " select * from clientes where cl_dni = ?", h, cu_dn1);
        } catch (Exception ex) {
            Logger.getLogger(Apertura_cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        
        return lista;
    }
}






//
//package dao;
//
//import model.Alumno;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//
//public class AlumnosDAO {
//
//    public List<Alumno> getAllAlumnos() {
//        List<Alumno> lista = null;
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            QueryRunner qr = new QueryRunner();
//            ResultSetHandler<List<Alumno>> h
//                    = new BeanListHandler<Alumno>(Alumno.class);
//            lista = qr.query(con, "select * FROM ALUMNOS ORDER BY ID DESC", h);
//
//        } catch (Exception ex) {
//            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return lista;
//    }
//
//    public List<Alumno> getAllAlumnosJDBC() {
//        List<Alumno> lista = new ArrayList<>();
//        Alumno nuevo = null;
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            con = db.getConnection();
//            stmt = con.createStatement();
//            String sql;
//            sql = "SELECT * FROM ALUMNOS ORDER BY ID DESC";
//            rs = stmt.executeQuery(sql);
//
//            //STEP 5: Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                int id = rs.getInt("id");
//                String nombre = rs.getString("nombre");
//                Date fn = rs.getDate("fecha_nacimiento");
//                Boolean mayor = rs.getBoolean("mayor_edad");
//                nuevo = new Alumno();
//                nuevo.setFecha_nacimiento(fn);
//                nuevo.setId(id);
//                nuevo.setMayor_edad(mayor);
//                nuevo.setNombre(nombre);
//                lista.add(nuevo);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            db.cerrarConexion(con);
//        }
//        return lista;
//
//    }
//    
//    public int actualizarAlumno(Alumno u)
//    {
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int filas = 0;
//        
//        try {
//            con = db.getConnection();
//            
//            String sql="UPDATE ALUMNOS SET NOMBRE=?, FECHA_NACIMIENTO=?, MAYOR_EDAD=? WHERE ID=?;";
//            
//            pstm = con.prepareStatement(sql);
//            
//            
//            pstm.setString(1,u.getNombre());
//            pstm.setDate(2, new java.sql.Date(u.getFecha_nacimiento().getTime()));
//            pstm.setBoolean(3, u.getMayor_edad());
//            pstm.setLong(4, u.getId());
//            
//            filas = pstm.executeUpdate();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return filas;
//    }
//    
//    public int borrarAlumno(Alumno u)
//    {
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int filas = 0;
//        
//        try {
//            con = db.getConnection();
//            
//            String sql="delete from ALUMNOS where id=?;";
//            
//            pstm = con.prepareStatement(sql);
//            
//            pstm.setLong(1, u.getId());
//            
//            filas = pstm.executeUpdate();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return filas;
//    }
//    
//    public int insertarAlumno(Alumno u)
//    {
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int filas = 0;
//        
//        try {
//            con = db.getConnection();
//            
//            String sql="INSERT INTO ALUMNOS (NOMBRE, FECHA_NACIMIENTO, MAYOR_EDAD) VALUES (?, ?, ?);";
//            
//            pstm = con.prepareStatement(sql);
//            
//            pstm.setString(1,u.getNombre());
//            pstm.setDate(2, new java.sql.Date(u.getFecha_nacimiento().getTime()));
//            pstm.setBoolean(3, u.getMayor_edad());
//            
//            filas = pstm.executeUpdate();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return filas;
//    }
//    
//    
//
//}

