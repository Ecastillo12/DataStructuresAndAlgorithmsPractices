
import java.util.InputMismatchException;//Se importa la librería
import java.util.Scanner;

public class Practica7 {// TRY CATCH (Intentar atrapar errores para que el programa no se desborde y que siga funcionando el programa).
    // Try catch puede usarse en cualquier método.
    public static void main(String[] args) {// Static, para llamar un método sin crear un objeto.
        System.out.println("El dato que usted escribió = "+Practica7.pedirDato());//java.util.InputMismatchException ERROR, pide un entero y le damos un string
    }
    public static int pedirDato(){
        Scanner teclado = new Scanner(System.in);
        int dato = 0;
        System.out.println("Dame un entero");
        try{//Se encierra donde haya error
        dato = teclado.nextInt();
        }catch(InputMismatchException error){
            dato = 100;
        }
        return dato;
    }
}
