/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author E_Cas
 */
public class Nodo {

    int dato;
    String nombre;
    Nodo hijoIzquierdo, hijoDerecho;

    public Nodo(int d, String nom) {
        this.dato = d;
        this.nombre = nom;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public String toString() {
        return nombre+" Su dato es "+dato;
    }
}
