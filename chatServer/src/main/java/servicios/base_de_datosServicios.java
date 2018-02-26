/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.base_datosDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import util.PasswordHash;

/**
 *
 * @author DAW
 */
public class base_de_datosServicios
{
    public int comprobar_usuario_existente (String user)
    {
        base_datosDAO a = new base_datosDAO();
        return a.comprobar_usuario_existente(user);
    }
    
    public boolean comprobar_usuario_y_pass (String user, String pass) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        base_datosDAO a = new base_datosDAO();
        String hash = a.comprobar_usuario_y_pass(user);
        return PasswordHash.validatePassword(pass, hash);
    }
    
    public int crear_nuevo_registro (String user, String pass) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        base_datosDAO a = new base_datosDAO();
        String hash = PasswordHash.createHash(pass);
        return a.crear_nuevo_registro(user, hash);
    }
}
