
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author tntqw
 */
//PRIORIDAD
public class ColasE3 {
    public static void main(String[] args) {
        Queue <Cliente> cola = new PriorityQueue();
        Queue aux = new LinkedList();
        Queue atendidos = new LinkedList();
        Queue espera = new LinkedList();
        
        System.out.println("cúantas lineas");
        int nl = new Scanner(System.in).nextInt();
        System.out.println("Escriba los datos:");
        Cliente nuevo = null;
        String x = "";
        int priori = 0;
        String name = "";
        boolean bandera = true;
        for (int i = 0; i < nl; i++) {
            x = new Scanner(System.in).nextLine().toLowerCase();
            if (x.charAt(0) == 'e') {
                //Aquí se define la prioridad B^)
                if(x.length()>=5){
                x = x.substring(2);
                int pos = x.indexOf(" ") + 1;
                priori = Integer.parseInt(x.substring(pos).trim());
                name = x.substring(0, pos-1);
                nuevo = new Cliente(priori, name);
                cola.offer(nuevo);
                bandera = true;
                }else{
                    bandera = false;
                    break;
                }
            } else if (x.charAt(0) == 'a') {
                if (cola.isEmpty()) {
                    aux.poll();
                } else {
                    aux.offer(x.charAt(0));
                }
            }
        }
        while (!cola.isEmpty()) {
            espera.offer(cola.poll().getNombre().toUpperCase());
        }
        if(bandera == true){
            while(aux.peek()!= null && !espera.isEmpty()){
                atendidos.offer(espera.poll());
                aux.poll();
            }
            System.out.println("Espera: "+espera);
            System.out.println("Atendidos: "+atendidos);
        }else{
            System.out.println("Escriba correctamente los datos!");
        }
        /*
        Líneas ejemplo: 
        e pedro 5
        e juan 2
        e gasa 9
        e luis 1
        e chon 7
        */
    }
}
