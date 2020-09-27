
import java.util.Scanner;


public class Practica13 {
    public static void main(String[] args) {
        Practica13 objeto = new Practica13();
        objeto.imprimirSerie(0, objeto.pedirRango());
    }
    public void imprimirSerie(int inicio, int fin){
        for (int i = inicio; i < fin; i++) {
            System.out.println(i+1);
        }
    }
    public int pedirRango(){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Escribe un número");
        int rango = teclado.nextInt();
        return rango;
    }
}
