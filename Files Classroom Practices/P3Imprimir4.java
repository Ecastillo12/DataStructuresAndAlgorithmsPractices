
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class P3Imprimir4 {
    static ArrayList<String> lineas = new ArrayList();
    public static void main(String[] args) {
        P3Imprimir4.leer();
        P3Imprimir4.imprimir();
    }
    //Regresa valor de tipo ArrayList<String>
    public static ArrayList<String> leer(){
        File Archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            Archivo = new File("src/nuevo.txt");
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
    
    public static void imprimir(){
        for (int i = 0; i < 4; i++) {
            System.out.println(lineas.get(i));
        }
    }
}
