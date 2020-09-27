package Recursividad;
/**
 *
 * @author tntqw
 */
public class Practica1 {
    public static void main(String[] args) {
        CapaSueño(0);
    }
    public static void CapaSueño(int level){
        if (level ==3){
            System.out.printf("Llegamos al nivel desado\n");
            return;//El return sirve como un break en caso de que sea recursivo
        } else{
            System.out.printf("Estamos en el nivel %d\n", level);
            CapaSueño(level + 1);
        }
        System.out.println("AQUI");//Se imprime cada vez que desapila
    }
}
