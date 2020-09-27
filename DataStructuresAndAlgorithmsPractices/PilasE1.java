import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Eduardo Castillo
 */
public class PilasE1 {
//INTERCAMBIO EN PILAS
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> duracell = new Stack();
        Stack<Integer> energizer = new Stack();
                
        duracell.push(0);
        duracell.push(2);
        duracell.push(3);
        duracell.push(3);
        duracell.push(4);
        duracell.push(5);
        duracell.push(10);
        
        System.out.println("Pila Original");
        System.out.println(duracell);
        System.out.println("Ingrese los números que quiere cambiar:");
        int a = input.nextInt(); int b = input.nextInt();        
        int c = 0, d = 0;
        boolean bandera;
        if (duracell.isEmpty()) {
            System.err.println("La pila está vacía");
            bandera = false;
        } else {
            if (duracell.contains(a) && duracell.contains(b)) {
                bandera = true;
                while (!duracell.empty()) {
                    if (duracell.peek() == a && c == 0) {
                        duracell.pop();
                        energizer.push(b);
                        c++;
                    } else if (duracell.peek() == b && d == 0) {
                        duracell.pop();
                        energizer.push(a);
                        d++;
                    } else {
                        int u = duracell.pop();
                        energizer.push(u);
                    }
                }
            } else {
                bandera = false;
            }
        }        
            if (bandera == false) {
                System.err.println("No pueden cambiarse los valores");
                System.out.println(duracell);
            } else {
                while (!energizer.isEmpty()) {
                    int u = energizer.pop();
                    duracell.push(u);
                }
                System.out.println("Datos Cambiados!");
                System.out.println(duracell);
            }
        }        
    }