
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

QD AD 8H 5S 3H 5H TC 4D JH KS 6H 8S JS AC AS 8D 2H QS TS 3S AH 4H TH TD 3C 6S 
8C 7D 4C 4S 7S 9H 7C 5D 2S KD 2D QH JD 6D 9D JC 2C KH 3D QC 6C 9S KC 7H 9C 5C

AC 2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AD 2D 3D 4D 5D 6D 7D 8D TD 9D JD QD KD
AH 2H 3H 4H 5H 6H 7H 8H 9H KH 6S QH TH AS 2S 3S 4S 5S JH 7S 8S 9S TS JS QS KS

3C 4C 5C 6C 7C 8C 9C TC JC QC KC AD 2D 3D 4D 5D 6D 7D 8D TD 9D JD QD KD AH 2H
3H 4H 5H 6H 7H 8H 9H KH 6S QH TH AS 2S 3S 4S 5S JH 7S 8S 9S TS JS QS KS 2C AC

 */
/**
 *
 * @author tntqw
 */
public class SolitarioAcordeon {
    //Metodo para saber si las cartas son compatibles
    public static boolean compatible (String a, String b) {
        //Si el valor de a es igual al valor de b ó el palo de a es igual al palo de b
        if (a.charAt(0) == b.charAt(0) || a.charAt(1) == b.charAt(1)) {
            //entonces si son compatibles y regresamos un valor verdadero
            return true;
        } else {
            // si no regresamos un valor falso
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String tmp1 = "";
        while(true) {
            //Primera linea de entrada            
            tmp1 = in.nextLine();
            //si es igual a # entonces rompe el ciclo
            if(tmp1.equals("#")){
                break;
            }// UNA CADENA PARA CADA LÍNEA
            String tmp2 = in.nextLine();
            //UNIMOS LAS CADENAS
            tmp1 = tmp1 + " " + tmp2;
            //creo un arreglo de string para agregar las cartas separadas por un espacio
            String[] aux = tmp1.split(" ");
            //lista tipo pila para obtener dicho elemento con .get(i)
            LinkedList<Pila> duracell = new LinkedList <Pila> ();
            //en este for each el tipo de elemento es string(el del arreglo) y voy a recorrer el arreglo tmp
            //para agregarlo a la lista de tipo pila
            for (String t : aux) {
                duracell.add(new Pila(t));
            }
            //hago un contador
            int i = 0;
            //Mientras i sea menor que el tamaño de la pila
            while (i < duracell.size()) {
                // hago tres cadenas, next3 donde este la tercer carta a la izquierda, cur que es la ultima carta de la pila y last1
                String next3, cur, last1;
                cur = duracell.get(i).peek();
                boolean removed = false;
                boolean rev3 = false;
                //validar los dos casos posibles:
                // 1.- La tercer carta a la izquierda:
                if (i - 3 >= 0) {
                    //la tercer carta a la izquierda es igual a la de i - 3 y obtengo el dato con .peek()
                    next3 = duracell.get(i - 3).peek();
                    //si la ultima carta es compatible(Se puede agregar) con la tercer carta a la izquierda
                    if (compatible(cur, next3)) {
                        //apilo (tres cartas a la izquierda) la carta compatible
                        duracell.get(i - 3).push(duracell.get(i).pop());
                        //valido si está vacio donde estaba, entonces borro el espacio
                        if (duracell.get(i).empty()) {
                            duracell.remove(i);
                        }
                        removed = true;
                        rev3 = true;
                    }
                }
                // 2.- La carta a la izquierda
                // primero valido si la carta a la izquierda no fue revisada ( no es compatible )
                if (i - 1 >= 0 && !rev3) {
                    //defino last1 como la carta a la izquierda de donde estoy y obtengo que carta es con .peek()
                    last1 = duracell.get(i - 1).peek();
                    //valido si es compatible la ultima carta, con la de la izquierda
                    if (compatible(cur, last1)) {
                        //apilo la ultima carta sobre la carta a la izquierda
                        duracell.get(i - 1).push(duracell.get(i).pop());
                        //valido si el espacio esta vacio, entonces lo quito
                        if (duracell.get(i).empty()) {
                            duracell.remove(i);
                        }
                        removed = true;
                    }
                }
                //si removí
                if (removed) {
                    i = 0;
                } else {
                    i++;
                }
            }
            String resp = "";
            //recorro la pila que quedó
            for (Pila s : duracell) {
                //defino la respuesta 
                resp = resp + " " + s;
            }
            if (duracell.size() == 1) {
                System.out.println("Queda 1 pila:" + resp);
            } else {
                System.out.println("Quedan "+duracell.size() + " pilas:" + resp);
            }

        }
    }
}
