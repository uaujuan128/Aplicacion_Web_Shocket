/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DAW
 */
public class Registro
{
    private String nombre;
    private String pass;

    public Registro()
    {
    }

    public Registro(String nombre)
    {
        this.nombre = nombre;
    }

    public Registro(String nombre, String pass)
    {
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }
    
    
    
}
