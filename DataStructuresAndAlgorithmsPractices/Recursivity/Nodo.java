package Recursividad;

public class Nodo {
    
    /* Declaraciones de variables */
    private int dato;
    private Nodo Izquierda;
    private Nodo Derecha;

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    /* Constructor */
    public Nodo(int dato) {
        this.dato = dato;
    }

    /* Setters y Getters */
    public int getDato() {
        return dato;
    }

    

    public Nodo getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(Nodo hojaIzquierda) {
        this.Izquierda = hojaIzquierda;
    }

    public Nodo getDerecha() {
        return Derecha;
    }

    public void setDerecha(Nodo hojaDerecha) {
        this.Derecha = hojaDerecha;
    }
    
}
