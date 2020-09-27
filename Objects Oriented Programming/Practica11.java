import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
Se quiere una aplicación, que permita manejar la información de un alumno. 
El alumno tiene nombre, apellido, sexo, fecha de nacimiento. Además como estudia
en una universidad tiene una fecha de ingreso.
En la aplicación se puede:
1.- Modificar los datos del alumno.
2.- Calcular la edad actual.
3.- Calcular cuántos años tiene en la universidad.

Las fechas, un tipo de dato para las fechas.
GregoryCalendar

Para convertir un date, es sólo a string.
 */
public class Practica11 {
    public static void main(String[] args) {
        Universidad obj = new Universidad();
        obj.calcularEdad();
    }
}
class Alumno{
private String añoNacimiento, añoIngreso;
private String nombre, apellido;
private int sexo;

    public String getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(String añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public String getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(String añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    public Alumno(int sexo, String nombre, String apellido, String añoNacimiento, String añoIngreso){
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoNacimiento = añoNacimiento;
        this.añoIngreso = añoIngreso;
    }
}
class Universidad{
    Calendar c1 = GregorianCalendar.getInstance();
    Date fechaActual = c1.getTime();
    Date fechaNAC= null;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    public void calcularEdad(){
        Scanner teclado = new Scanner(System.in);
        int edad = 0;
        try{
        System.out.println("Ingresa tu fecha de nacimiento en formato YYYY-MM-DD");
        String Nacimiento = teclado.nextLine();
        fechaNAC = formato.parse(Nacimiento);
        }catch(ParseException ex){
            System.out.println("No se ingresó correctamente la fecha de nacimiento");
        }
        edad = fechaActual.getYear() - fechaNAC.getYear();
        System.out.println("Su edad es: "+edad);
    }
    public void calcularAnti(){
        int anti = 0;
    }
}