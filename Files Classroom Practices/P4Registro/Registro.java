package P4Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class Registro {

    static String nombre;
    static String edad;
    static int id = 0;

    public static void main(String[] args) {
        Registro.Menu();
    }

    public static void Menu() {
        Scanner input = new Scanner(System.in);
        int c = -1;
        while (c != 0) {
            System.out.println(":::::::MENU:::::::\n"
                    + "1.- Agregar\n"
                    + "2.- Imprimir\n"
                    + "0.- Salir");
            c = input.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Escriba el nombre");
                    String name = input.next();
                    System.out.println("Escriba la edad");
                    String age = input.next();
                    id++;
                    Registro.agregar(name, age, id);
                    break;
                case 2:
                    Registro.imprimir(Registro.leer());
                    break;
                default:
                    System.out.println("Gracias por usar");
                    break;
            }
        }
    }

    public static void agregar(String name, String age, int id) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String enteroString = Integer.toString(id);
            fichero = new FileWriter("src/P4Registro/Lista.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(enteroString + "&" + name + "&" + age);
        } catch (IOException ex) {

        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                    pw.close();
                } catch (IOException ex) {

                }
            }
        }
    }

    public static ArrayList<String> leer() {
        ArrayList<String> Lista = new ArrayList();
        File Archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;
        try {
            Archivo = new File("src/P4Registro/Lista.txt");
            fr = new FileReader(Archivo);
            br = new BufferedReader(fr);
            sc = new Scanner(br);
            String Linea;
            while ((Linea = br.readLine()) != null) {
                Lista.add(Linea);
            }
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lista;
    }
    public static void imprimir(ArrayList<String> lista){
        Scanner input = new Scanner(System.in);
        int opc=-1;
        String x[]= new String[3];
        while(opc!=0){
            System.out.println("¿Qué quiere imprimir?\n"
                    + "1.-ID\n"
                    + "2.-Nombre\n"
                    + "3.-Edad\n"
                    + "0.-Salir\n");
            opc = input.nextInt();
            switch(opc){
                case 1:
                    for (int i = 0; i < lista.size(); i++) {
                        x = lista.get(i).split("&");
                        System.out.println(x[0]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < lista.size(); i++) {
                        x = lista.get(i).split("&");
                        System.out.println(x[1]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < lista.size(); i++) {
                        x = lista.get(i).split("&");
                        System.out.println(x[2]);
                    }
                    break;
                default:
                    System.out.println("Gracias por usar");
                    break;
            }
        }
    }
}
