
import java.util.ArrayList;
import java.util.Scanner;


public class Practica8 {//Arraylist. Es una clase hecha por java.
    //Ordenar los objetos por lugares: Perro1---->0/Perro2------>1/Perro3------>2

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Perros> bD = new ArrayList();//Cada molde o clase se convierte en un tipo de datos.
        //Base de datos es el objeto de este ArrayList.
        Perros Max = new Perros("Pastor","Max","blanco con café");//Se crea el objeto max
        bD.add(Max);//Y se agrega
        bD.add(new Perros("Chihuaha","paquiao","café"));//O al agregar se puede crear el objeto perro, así no se guarda el objeto con el nombre.
        System.out.println("Escriba el número del perro");
        int pos = teclado.nextInt();
        Perros var = bD.get(pos);//Se obtiene el perro 1 y se guarda en la variable var.
        System.out.println(var.getNombre().toUpperCase());//Se obtine el nombre, se convierte en mayusculas y se imprime
        System.out.println("Escriba el número de cuantas veces quiere que ladre");
        int la = teclado.nextInt();
        var.ladrar(la);//Se hace que ladre, las veces que estén en el parentesis.
        System.out.println("Cuantos perros quieres");
        int ca = teclado.nextInt();
        
                
        for (int i = 0; i <ca; i++) {
            System.out.println("raza");
            String raza = teclado.nextLine();
            System.out.println("color");
            String color = teclado.nextLine();
            bD.add(new Perros(raza,color));
        }
        //Imprimir datos de los perros
        for (int i = 0; i < bD.size(); i++) {
            System.out.println("Perro"+i+" "+bD.get(i).getRaza());
        }
    }
}
//Normalmente los atributos se crean en otra clase, para obtenerlos por medio del getter & setter.

class Perros {

    private int id;
    private String raza;
    private String Nombre;
    private String color;
    private int edad;

    public Perros(int id, String raza, String Nombre, String color, int edad) {
        this.id = id;
        this.raza = raza;
        this.Nombre = Nombre;
        this.color = color;
        this.edad = edad;
    }

    public Perros(String raza, String Nombre, String color) {
        this.raza = raza;
        this.Nombre = Nombre;
        this.color = color;
    }

    public Perros(String raza, String color) {
        this.raza = raza;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void ladrar(int ladridos) {
        for (int i = 0; i < ladridos; i++) {
            System.out.println("Guof!!");
        }
    }

}
