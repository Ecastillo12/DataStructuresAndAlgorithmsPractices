
/*
Se quiere construir una aplicación para una tienda de libros. La tienda tiene 
un catálogo o colección de libros que ofrece para la venta. Los libros tienen 
un ISBN que los identifica de manera única, un título y un precio de venta. 
La tienda tiene una disponibilidad ilimitada de los libros que ofrece. 
Cuando un cliente llega a la tienda a comprar libros, utiliza un carrito 
de compras. En el carrito de compras adiciona los libros que quiere comprar. 
El cliente puede llevar más de un ejemplar de cada libro. Al revisar la cuenta,
el cliente debe poder ver el subtotal de cada libro según la cantidad de 
ejemplares que lleve de él, y el total de toda la compra que es igual a la 
suma de los subtotales. El cliente puede arrepentirse de alguna compra y 
borrar del carrito que guste.
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Extra2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        tienda obj = new tienda();        
        int opc = 0;
        obj.agregarLibro();
        System.out.println("_____MENU____\n"
                    + "1.- Agregar un libro al carrito\n"
                    + "2.- Eliminar un libro del carrito\n"
                    + "3.- Ver cuenta\n"
                    + "4.- Salir\n"
                + "Opcion:");
        opc = input.nextInt();
        do{            
            switch(opc){
                case 1:
                    obj.comprarLibro();
                    break;
                case 2:
                    obj.eliminarLibro();
                    break;
                case 3:
                    obj.verCuenta();
                    break;
                case 4:
                    
                    break;
                
                
            }
        }while(opc!=4);
    }    
}
class Libro{
    
    private String ISBN;
    private String titulo;
    private int precio;
    
    public Libro(String isbn, String titulo, int precio){
        this.ISBN=isbn;
        this.titulo=titulo;
        this.precio=precio;
    }    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
     
}
class tienda{
    ArrayList<Libro> inventario = new ArrayList();
    ArrayList<Libro> carrito = new ArrayList();
    public void comprarLibro(){
        Scanner input = new Scanner(System.in);
        System.out.println("Elija el libro a comprar:");
        for (int i = 0; i < inventario.size() ; i++) {
            System.out.println(i+".-"+inventario.get(i).getTitulo()+" $"+inventario.get(i).getPrecio());
        }
        int n = input.nextInt();
        carrito.add(new Libro(inventario.get(n).getISBN(),inventario.get(n).getTitulo(),inventario.get(n).getPrecio()));
    }
    public void eliminarLibro(){
        Scanner input = new Scanner(System.in);
        System.out.println("Elija el libro a eliminar:");
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println(i+" "+carrito.get(i).getTitulo()+ " $"+carrito.get(i).getPrecio());
        }
        int n = input.nextInt();
        carrito.remove(n);
    }
    public void agregarLibro(){
        inventario.add(new Libro("PSR1","PLUTÓN 1",35));
        inventario.add(new Libro("PSR2","PLUTON 2",40));
        inventario.add(new Libro("PSR3","PLUTÓN 3",45));
        
    }
    public void verCuenta(){
        double total = 0;
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println(carrito.get(i).getTitulo()+" $"+carrito.get(i).getPrecio());
        }
        for (int i = 0; i < carrito.size(); i++) {
            total = total+carrito.get(i).getPrecio();
        }
        System.out.println("$"+total);
    }
}


