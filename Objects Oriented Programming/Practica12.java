
import java.util.Scanner;


public class Practica12 {
     public static void main(String[] args) {
        Practica12 obj = new Practica12();
        String cad = obj.pedirCadena();
        if (obj.validarCadena(cad)) {
            cad = obj.girarCadena(cad);
            obj.imprimirCadena(cad);
        } else {
            System.out.println("NO SE REALIZA ROTACIÓN");
        }
    }

    public String pedirCadena() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce una cadena");
        String cadena = leer.nextLine();
        return cadena;
    }

    public void imprimirCadena(String cad) {
        System.out.println(cad);
    }

    public boolean validarCadena(String cadena) {
        boolean esPar = false;
        if (cadena.length() % 2 == 0 && cadena.length() != 0) {
            esPar = true;
        }
        return esPar;
    }

    public String girarCadena(String cadena) { //hola
        int mitad = cadena.length() / 2;
        String nuevaCadena = cadena.substring(mitad, cadena.length())
                + cadena.substring(0, mitad);
        return nuevaCadena;
    }
}
