
import java.util.Scanner;


public class Practica14 {
    public static void main(String[] args) {
        System.out.println("Ingrese el valor de n\n"
                + "!!!!Meñique!!!!");
        Practica14.serieSuma(new Scanner(System.in).nextInt());
    }
public static long serieSuma(int n){
    long suma = 0;
    
    if(n>0){
        for (int i = 1; i <= n; i++) {
            suma = suma+i;
        }
        System.out.println("Numero: "+suma);
    }else{
        System.out.println("Ingrese un número positivo, o no funca :C");
    }
    return suma;
}    
}
