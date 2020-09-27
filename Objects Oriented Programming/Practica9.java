/*
 En la alcancía es posible guardar monedas de las siguientes denominaciones; $20, $50, $100, $200, $500, no se guardan ni billetes ni monedas
 de otras denominaciones. Al dueño de la alcancía le parece muy útil conocer cuánto tiene en la alcancía sin
 necesidad de romperla, es más, él quiere conocer cuantas monedas tiene en cada denominación 
 para así romper la alcancía sólo cuando quiera disponer todo su dinero ahorrado.

 1.- Agregar una moneda de una de las denominaciónes indicadas.
 2.- Contar cuántas monedas tiene de cada denominación.
 3.- Calcular el total de dinero ahorrado.
 4.- Romper la alcancía.
 5.- Comenzar una nueva alcancía.
 */


import java.util.Scanner;

public class Practica9 {

    public static void main(String[] args) {
        //La importancia de tener atributos, esque la clase puede acceder a los atributos y si se pone en un método se pierde al terminar el método.
        Scanner teclado = new Scanner(System.in);
        Alcancia obj = new Alcancia();
        int select = -1;
        //menu
        while (select != 0) {
            //Try catch para evitar que el programa termine si hay un error
            try {
                System.out.println("Elige opción:\n1.- Agregar moneda de 20"
                        + "\n2.- Agregar moneda de 50\n"
                        + "3.- Agregar moneda de 100\n"
                        + "4.- Agregar moneda de 200\n"
                        + "5.- Agregar moneda de 500\n"
                        + "6.-Contar monedas\n"
                        + "7.-Calcular total\n"
                        + "8.-Romper almancía");
                //Recoger una variable por consola
                select = Integer.parseInt(teclado.nextLine());

                //Ejemplo de switch case en Java
                switch (select) {
                    case 1:
                        obj.agregarM20();
                        break;
                    case 2:
                        obj.agregarM50();
                        break;
                    case 3:
                        obj.agregarM100();
                        break;
                    case 4:
                        obj.agregarM200();
                        break;
                    case 5:
                        obj.agregarM500();
                        break;
                    case 6:
                        System.out.println(":::::::CONTEO DE MONEDAS::::::");
                        System.out.println("Monedas de 20: "+obj.cantidadM20());
                        System.out.println("Monedas de 50: "+obj.cantidadM50());
                        System.out.println("Monedas de 100: "+obj.cantidadM100());
                        System.out.println("Monedas de 200: "+obj.cantidadM200());
                        System.out.println("Monedas de 500: "+obj.cantidadM500());
                        break;
                    case 7:
                        obj.calcularDinero();
                        break;
                    case 8:
                        obj.romperAlcancia();
                        select = 0;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }

                System.out.println("\n"); //Mostrar un salto de línea en Java

            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }
        }

    }
}

class Alcancia {

    private int m20;
    private int m50;
    private int m100;
    private int m200;
    private int m500;

    public Alcancia() {
        this.m20 = 0;
        this.m50 = 0;
        this.m100 = 0;
        this.m200 = 0;
        this.m500 = 0;
    }

    public void agregarM20() {
        this.m20++;
        System.out.println("Moneda agregada");
    }

    public void agregarM50() {
        this.m50++;
        System.out.println("Moneda agregada");
    }

    public void agregarM100() {
        this.m100++;
        System.out.println("Moneda agregada");
    }

    public void agregarM200() {
        this.m200++;
        System.out.println("Moneda agregada");
    }

    public void agregarM500() {
        this.m500++;
        System.out.println("Moneda agregada");
    }

    public int cantidadM20() {
        return this.m20;
    }

    public int cantidadM50() {
        return this.m50;
    }

    public int cantidadM100() {
        return this.m100;
    }

    public int cantidadM200() {
        return this.m200;
    }

    public int cantidadM500() {
        return this.m500;
    }

    public long calcularDinero() {
        long total = 0;
        total = this.m20 * 20 + this.m50 * 50 + this.m100 * 100 + this.m200 * 200 + this.m500 * 500;
        System.out.println("El total es: $"+total);
        return total;
    }

    public void romperAlcancia() {
        this.m20 = 0;
        this.m50 = 0;
        this.m100 = 0;
        this.m200 = 0;
        this.m500 = 0;
    }

}

