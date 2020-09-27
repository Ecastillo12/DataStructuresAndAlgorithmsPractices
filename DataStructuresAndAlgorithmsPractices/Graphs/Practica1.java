/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author E_Cas
 */
public class Practica1 {
    //atributo
    static ArrayList<String> nodos = new ArrayList();
    static int[][] matriz;
    final static int dirigido = 1;
    final static int noDirigido = 2;
    static int tipoGrafo;

    public static void generarNodos(int cantidad) {
        System.out.println("Agregue las etiquetas");
        for (int i = 0; i < cantidad; i++) {
            nodos.add(new Scanner(System.in).next());
        }
        Collections.sort(nodos);
    }

    public static void tamañoMatriz() {
        matriz = new int[nodos.size()][nodos.size()];
    }

    public static void pedirCaminos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            String camino[] = new Scanner(System.in).next().split("-");
            buscarPosicion(camino[0],camino[1]);            
        }
    }
    
    public static void llenarMatrizIdentidadDirigido(int vector[]){
        matriz[vector[0]][vector[1]] = 1;
    }
    public static void llenarMatrizIdentidadNoDirigido(int vector[]){
        matriz[vector[0]][vector[1]] = 1;
        matriz[vector[1]][vector[0]] = 1;
    }
    

    public static void pedirTipo() {
        System.out.println("Seleccione el tipo de grafo");
        int opc = -1;
        do {
            System.out.println("1.- Dirigido\n"
                    + "2.- No Dirigido");
            opc = new Scanner(System.in).nextInt();
            tipoGrafo = opc;
        } while (opc != 1 && opc != 2);

    }

    public static int[] buscarPosicion(String a, String b) {
        int vector[]= {Collections.binarySearch(nodos, a),Collections.binarySearch(nodos, b)};
        return vector;
    }
    public static void imprimirMatriz(){
        
    }

    public static void main(String[] args) {
        System.out.println("¿Cuántos nodos?");
        generarNodos(new Scanner(System.in).nextInt());
        pedirTipo();
        System.out.println("Caminos:");
        pedirCaminos(new Scanner(System.in).nextInt());
        

    }
}
