
package model;
public class Mensaje_mio
{
    private String tipo;
    private String contenido;
    private String destino;
    private String fecha;
    private String usuario;
    private boolean se_guarda;

    public Mensaje_mio()
    {
    }

    public Mensaje_mio(String tipo, String contenido, String destino, String fecha, String usuario, boolean se_guarda)
    {
        this.tipo = tipo;
        this.contenido = contenido;
        this.destino = destino;
        this.fecha = fecha;
        this.usuario = usuario;
        this.se_guarda = se_guarda;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getContenido()
    {
        return contenido;
    }

    public void setContenido(String contenido)
    {
        this.contenido = contenido;
    }

    public String getDestino()
    {
        return destino;
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public boolean isSe_guarda()
    {
        return se_guarda;
    }

    public void setSe_guarda(boolean se_guarda)
    {
        this.se_guarda = se_guarda;
    }
    
    
}
