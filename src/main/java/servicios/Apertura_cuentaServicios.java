/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.Apertura_cuentaDAO;
import java.util.List;
import model.Cliente;

/**
 *
 * @author DAW
 */
public class Apertura_cuentaServicios
{
    public int comprobar_cuenta_existente(String cu_ncu2)
    {
        Apertura_cuentaDAO dao = new Apertura_cuentaDAO();
        return dao.comprobar_cuenta_existente(cu_ncu2);
    }
    public String comprobar_dni_existente(String cu_dn1)
    {
        Apertura_cuentaDAO dao = new Apertura_cuentaDAO();
        
        List<Cliente> lista_cliente = (List<Cliente>) dao.comprobar_dni_existente(cu_dn1);
        String resultado = null;
        if (lista_cliente.size() > 0)
        {
            Cliente cliente = lista_cliente.get(0);
            resultado = "Este cliente ya existe. Éstos son sus datos: ";
        }
        else
        {
            
        }
        
        return resultado;
    }
}
