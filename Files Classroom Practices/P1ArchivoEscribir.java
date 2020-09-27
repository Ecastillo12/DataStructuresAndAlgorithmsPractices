
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class P1ArchivoEscribir {

    public static void main(String[] args) {
        P1ArchivoEscribir.EscribirArchivo();
        
    }
    public static void EscribirArchivo() {
        //FileWriter No salta renglones, es mas límitado al escribir
        FileWriter fichero = null;
        //PrintWriter Sí salta renglones, tiene más libertad para escribir. 
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/nuevo.txt", false);
            pw = new PrintWriter(fichero);
            for (int i = 1; i <=100; i++) {
                //escribir en el archivo
                pw.println("contando hasta 100 este es: "+i);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            //aqui entra tenga error o no
            if (fichero != null) {
                try {
                    fichero.close();
                    pw.close();
                } catch (IOException ex) {

                }
            }
        }
    }
    public static void LeerArchivo() throws IOException{
        //es un objeto que hace referencia al archivo
        //hace referencia a la hoja
        //puedes saber la ruta, el tamaño y el tipo
        File Archivo = null;
        //Encargado de obtener lo que hay en el archivo
        //significa que prepara el archivo para que sea
        //de lectura
        FileReader fr = null;
        //pariente del scanner,
        BufferedReader br = null;
        Scanner sc = null;
        try{
            //Apertura del fichero y creacion del buffer
            //para poder hacer una lectura comoda
            //(disponer del método readLine()).
            Archivo = new File("src/prueba2.txt");
            //fr puede leer el archivo pero no tiene salto de linea.
            fr = new FileReader(Archivo);
            //entonces ocupa a bufferedReader, este tendrá salto de linea.
            br = new BufferedReader(fr);
            //este tiene salto de linea, pero aparte tiene metodos que leen int, double, float, etc.
            sc = new Scanner(fr);
            
            String Linea;
            //Aqui también podemos usar el scanner
            while((Linea=br.readLine())!=null){
                System.out.println(Linea);
            }
        }catch(Exception e){
            
        } finally{
            if(fr!=null){
                fr.close();
            }
        }
    }

    }

