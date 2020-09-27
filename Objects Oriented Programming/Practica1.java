
import java.util.Scanner;


public class Practica1 {
    //atributos
    private int numero1;
    private int numero2;
    private int resultado;
    
    //metodos
    //metodo de pedir datos
    public void pedirDatos(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el valor 1");
        this.numero1 = teclado.nextInt();
        System.out.println("Introduce el valor 2");
        this.numero2 = teclado.nextInt();
    }
    //método sumar
    public void sumar(){
        System.out.println("SUMA");
        this.resultado = this.numero1+this.numero2;
        
    }
    public void restar(){
        System.out.println("Resta");
        this.resultado = this.numero1-this.numero2;
        
    }
    public void imprimirResultado(){
        System.out.println("El resultado es: "+this.resultado);
    }
    public static void main(String[] args) {
        Practica1 obj1 = new Practica1();
        obj1.pedirDatos();
        obj1.sumar();
        obj1.imprimirResultado();
        Practica1 obj2 = new Practica1();
        obj2.pedirDatos();
        obj2.restar();
        obj2.imprimirResultado();
    }
}
