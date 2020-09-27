
package Practica5;

import java.util.Scanner;

public class Escuela {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Persona lalo = new Persona("Eduardo");//Pedir nombre por medio del constructor
        Persona jaqui = new Persona("Jacqueline");//El constructor es el primer método que se llama para construir el objeto. Tiene el mismo nombre que la clase.
        //Primer persona
        lalo.setNombre("Eduardo Salvador");//Pedir nombre
        lalo.setApellidoP("Castillo");
        lalo.setApellidoM("González");
        //Segunda Persona
        jaqui.setNombre("Jacqueline");//Pedir nombre
        jaqui.setApellidoP("Vélez");
        jaqui.setApellidoM("Cruz");
        
        System.out.println(lalo.getNombre()+" "+lalo.getApellidoP()+" "+lalo.getApellidoM());//Obtener los datos(get) e imprimirlos(sout)
        System.out.println(jaqui.getNombre()+" "+jaqui.getApellidoP()+" "+ jaqui.getApellidoM());
        
        Persona Carlos = new Persona();
        Carlos.setNombre("Carlos Manuel");
        Carlos.setApellidoP("Ramos");
        Carlos.setApellidoM("Vega");
        Carlos.setEdad("18");
        Carlos.setSexo("Masculino");
        System.out.println(Carlos.getNombre()+" "+Carlos.getApellidoP()+" "+Carlos.getApellidoM()+"\n Edad: "+Carlos.getEdad()+" sexo: "+Carlos.getSexo());
        
        Persona Ho = new Persona();
        System.out.println(Ho.getNombre()+" "+Ho.getApellidoP()+" "+Ho.getApellidoM()+"\n "+Ho.getEdad()+" "+Ho.getSexo());
        
        Persona Ha = new Persona("Pedro", "Cruz", "Alejandre");
        
    }
}
