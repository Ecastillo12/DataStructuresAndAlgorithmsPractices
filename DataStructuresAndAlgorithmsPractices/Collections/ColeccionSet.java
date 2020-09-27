/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author E_Cas
 */
public class ColeccionSet {
    /*Una colección que no contiene elementos duplicados. 
    Más formalmente, los conjuntos (sets) no contienen ningún par de elementos e1 y e2
    tales como e1.equals (e2), y como máximo un elemento nulo. 
    Tal como lo implica su nombre, esta interfaz modela la abstracción 
    del conjunto matemático.
    La interfaz Set establece estipulaciones adicionales, más allá de 
    las heredadas de la interfaz Collection, en los contratos de todos 
    los constructores y en los contratos de los métodos add, equals y hashCode. 
    Las declaraciones para otros métodos heredados también se incluyen aquí por 
    conveniencia. (Las especificaciones que acompañan a estas declaraciones se 
    han adaptado a la interfaz Set, pero no contienen ninguna estipulación adicional).
*/    
    //Set hola = new Set();
    public static void hacerSet(){
        int arreglo[] = {34, 22,10,60,30,22};
      Set<Integer> set = new HashSet<Integer>();
      try {
         for(int i = 0; i < 6; i++) {
            set.add(arreglo[i]);
         }
         System.out.println(set);

         TreeSet sorted = new TreeSet<Integer>(set);
         System.out.println("La lista:");
         System.out.println(sorted);

         System.out.println("El primer elemento de la coleccion es: "+ (Integer)sorted.first());
         System.out.println("El ultimo elemento de la coleccion es: "+ (Integer)sorted.last());
      }
      catch(Exception e) {}
   }
    
    public static void hacerHashSet(){
        HashSet s = new HashSet();
        //Agregar al conjunto
        System.out.println(s.add(new Integer(4)));//   <-------- Las colecciones no admiten tipos primitivos
        //con lo que deberemos envolver el tipo con la clase específica.
        s.add(new Integer(4));
        s.add(new Integer(7));
        s.add(new String("camara"));
        System.out.println(s);//Aquí se puede ver como elimina uno de los elementos repetidos.
        s.remove("camara");//Eliminar el conjunto, requiere especificar el conjunto a eliminar.
        System.out.println(s);
        s.clear();//elimina todos los elementos de la colección.
        System.out.println(s);
        System.out.println("Tamaño de la colección: "+s.size());
    }
    public static void hacerTreeSet(){
        TreeSet t = new TreeSet();
        t.add(new Integer(1));
        t.add(new Integer(2));
        t.add(new Integer(3));
        t.add(new Integer(4));
        t.add(new Integer(5));
        t.add(new Integer(6));
        t.add(new Integer(7));
        t.add(new Integer(8));
        t.add(new Integer(9));
        t.add(new Integer(10));
        System.out.println(t.higher(5));
        
        /*
        Supongamos que en nuestra colección tenemos los números
        del 1 al 10. Si utilizamos la sentencia anterior nos dará 
        como resultado el número que sea superior a 5 pero 
        el menor de la colección, con lo cual nos dará 6, ya que 
        si empezamos a contar desde 5, nos quedará del 6 al 10 y 
        el menor de 6 a 10 es 6.*/
        System.out.println(t.lower(10));
        /*
        Volviendo a nuestra colección del 1 al 10, si tenemos 5 tiene 
        que elegir un número que sea menor que el elemento pasado, 
        por lo tanto nos quedará del 4 al 1, y el elemento mayor de 
        estos últimos es 4, así que ese sería el resultado.
        */
        t.pollFirst();//Elimina el primer elemento de la colección. Devuelve null si esta vacía.
        t.pollLast();//Elimina el último elemento de la colección. Devuelve null si esta vacía.
    }
    public static void main(String[] args) {
        hacerHashSet();
        hacerTreeSet();
        hacerSet();
    }
    
}
