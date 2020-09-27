/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tntqw
 */
public class Cliente implements Comparable<Cliente>{
    private int prioridad;
    private String nombre;
    
    @Override
    public int compareTo(Cliente x){
        int r = 0;
        if(x.getPrioridad() > getPrioridad()){
            r = 1;
        }else if(x.getPrioridad() < getPrioridad())
            r = -1;
        return r;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(int prioridad, String nombre) {
        this.prioridad = prioridad;
        this.nombre = nombre;
    }
}
