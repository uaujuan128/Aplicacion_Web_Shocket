/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Registro;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author DAW
 */
public class base_datosDAO
{
    public int comprobar_usuario_existente(String user)
    {
        long resultado = 0;
        DBConnection db = new DBConnection();
        List<Registro> lista = null;
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Registro>> h = new BeanListHandler<>(Registro.class);
            lista = qr.query(con, "select nombre from registro where nombre = ?", h, user);
            
            if (lista.size() > 0)
                {
                    resultado = 1;
                }
            
            
        } catch (Exception ex) {
            Logger.getLogger(base_datosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        
        return (int) resultado;
    }
    public String comprobar_usuario_y_pass(String user)
    {
        String hash = null;
        DBConnection db = new DBConnection();
        List<Registro> lista = null;
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Registro>> h = new BeanListHandler<>(Registro.class);
            lista = qr.query(con, "select pass from registro where nombre = ?", h, user);
            
            hash = lista.get(0).getPass();
            
            
        } catch (Exception ex) {
            Logger.getLogger(base_datosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        
        return hash;
    }
    
    public int crear_nuevo_registro(String user, String hash) {
        Connection con = null;
        DBConnection db = new DBConnection();
        int filas = 0;
        try {
            con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into registro values (?, ?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user);
            stmt.setString(2, hash);

            filas = stmt.executeUpdate();


        } catch (Exception ex) {
            Logger.getLogger(base_datosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }

        return filas;
    }
    
}
