
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P2Convertir {
    
        static ArrayList<String> lineas = new ArrayList();
    public static void main(String[] args) {
        P2Convertir.Leer();
        P2Convertir.Escribir();
    }
    public static ArrayList Leer(){
        File Archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            Archivo = new File("src/prueba.txt");
            fr = new FileReader(Archivo);
            br = new BufferedReader(fr);
            String Linea;
            while((Linea=br.readLine())!=null){
                lineas.add(Linea);
            }
        }catch(IOException e){
        
    } finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(P2Convertir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lineas;
    }
    public static void Escribir(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("src/prueba.txt", false);
            pw = new PrintWriter(fichero);
            lineas = P2Convertir.Leer();
            
            for (int i = 0; i < lineas.size(); i++) {
            pw.println(lineas.get(i).toUpperCase());
        }
        }catch(IOException ex){
            
        } finally {
            if(fichero!=null){
                try{
                    fichero.close();
                }catch(IOException ex){
                    
                }
            }
        }
            
    }
}
