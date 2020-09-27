package P5Inventario;

import java.io.Serializable;

/**
 *
 * @author Eduardo
 */
public class Cliente implements Serializable {
    private int clave;
    private String nombre;

    public Cliente(int clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
