package Recursividad;
/**
 *
 * @author tntqw
 */
public class Practica2 {
    private static void sumar(int x){
        System.out.println("X tiene el valor de" +x);
        if(x!=10){
            sumar(x+1);
            System.out.println("hola "+x);
        }
        System.out.println(x);
    }
    public static void main(String[] args) {
        sumar(0);
    }
}
