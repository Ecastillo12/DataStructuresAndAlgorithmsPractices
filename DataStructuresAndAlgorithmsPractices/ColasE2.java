import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author Eduardo Castillo
 */
//COLAS
public class ColasE2 {
    public static void main(String[] args) {
        Queue cola = new LinkedList();
        Queue atendidos = new LinkedList();
        Queue aux = new LinkedList();
        System.out.println("Escribe el número de lineas: ");
        int nl = new Scanner(System.in).nextInt();
        System.out.println("Escribe los datos:");
        boolean bandera = true;
        for (int i = 0; i < nl; i++) {
            String entrada = new Scanner(System.in).nextLine().toLowerCase();            
                if (entrada.charAt(0) == 'e') {
                    if (entrada.length() >= 3) {
                    cola.offer(entrada.substring(2).toUpperCase());
                    bandera = true;
                    }else{
                        bandera = false;
                        break;
                    }
                } else if (entrada.charAt(0) == 'a') {
                    if(cola.isEmpty()){
                        aux.poll();
                    }else{
                    aux.offer(entrada.charAt(0));
                    }
                }    
        }
        if(bandera == true){
        while (aux.peek() != null && !cola.isEmpty()) {
            atendidos.offer(cola.poll().toString().toUpperCase());
            aux.poll();
        }
        //PRIORITY QUEUE
        System.out.println("EN ESPERA: " + cola);
        System.out.println("ATENDIDOS: " + atendidos);
        }else{
            System.out.println("Escriba correctamente los datos!");
        }
    }
}
