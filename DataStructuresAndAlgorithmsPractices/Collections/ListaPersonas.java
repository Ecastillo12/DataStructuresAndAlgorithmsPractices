/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author E_Cas
 */
public class ListaPersonas {

    private ArrayList<Persona> listapersona = null; // Campo de la clase

    public ListaPersonas() {
        listapersona = new ArrayList<Persona>();
    } // Constructor de la clase

    public ArrayList<Persona> getListaPersonas() {
        return listapersona;
    } //Omitimos otros métodos

    public Iterator<Persona> iterator() {
        return new MiIteradorListaPersonas();
    } // Método de la clase

    @Override
    public String toString() {
        return listapersona.toString();
    } // Método de la clase

    protected class MiIteradorListaPersonas implements Iterator<Persona> // Clase interna
    {

        public int posicion = 0;
        public boolean sepuedeeliminar = false; // Campos

        @Override
        public boolean hasNext() {
            return posicion < listapersona.size();
        } // Método

        @Override
        public Persona next() { // Método
            Persona res = listapersona.get(posicion); // Creamos un objeto Persona igual al que recorremos
            posicion++;
            sepuedeeliminar = true;
            return res;
        }

        @Override
        public void remove() {
            if (sepuedeeliminar) {
                listapersona.remove(posicion - 1);
                posicion--;
                sepuedeeliminar = false;
            }
        } // Cierre del método remove
    } // Cierre de la clase interna

    public static void main(String[] args) {
        ListaPersonas lista = new ListaPersonas();
        Iterator<Persona> it;
        Persona e;
        lista.getListaPersonas().add(new Persona(1, "Carlos", 175));
        lista.getListaPersonas().add(new Persona(1, "Fernando", 172));
        lista.getListaPersonas().add(new Persona(1, "Alcahuete", 155));
        System.out.println("Lista de personas: \n" + lista.toString());
        it = lista.iterator();
        while (it.hasNext()) {
            e = it.next();
            if (e.getAltura() < 170) {
                it.remove();
            } // it.remove() elimina la persona de la colección
        }
        System.out.println("Lista después de recorrer/eliminar: \n" + lista.toString());
    }


}
