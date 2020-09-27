
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Se quiere construir un programa para manejar los resultados de una encuesta de opinion
en la encuesta se dividieron las personas en 3 rangos de edad
1.-Menores o iguales a los 18 años
2.-Entre 19 y 60 años
3.-De 61 años o más
La encuesa consiste en una unica pregunta en la cual se le pide a la persona
que califique(del 0 al 10) un curso pero se tiene que preguntar que si es soltero o casado
el programa debe informar los resultados de la encuesta
número de opiniones, promedio de las calificaciones dadas en cada persona.
 */
public class Practica10 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        encuesta obj = new encuesta();
        System.out.println("¿Cuántas personas encuestadas?");
        int u = teclado.nextInt();
        for (int i = 0; i < u; i++) {
            obj.crearPersona();

        }

        obj.clasificar();
        System.out.println("Número de opiniones: " + u);
        System.out.println("Calificaciones solteros " + obj.cal1);
        System.out.println("Calificaciones casados " + obj.cal2);
        System.out.println("SOLTERO");
        System.out.println(obj.soltero);
        System.out.println("CASADO");
        System.out.println(obj.casado);
        System.out.println("MENOR DE 18");
        System.out.println(obj.menor18);
        System.out.println("EDAD MEDIA");
        System.out.println(obj.medio);
        System.out.println("MAYOR DE 61");
        System.out.println(obj.mayor61);
        System.out.println("PROMEDIO MENOR DE 18");
        System.out.println(obj.prom = obj.calm / obj.menor18);
        System.out.println("PROMEDIO EDAD MEDIA");
        System.out.println(obj.prome = obj.calme / obj.medio);
        System.out.println("PROMEDIO MAYOR DE 61");
        System.out.println(obj.proma = obj.calma / obj.mayor61);
        System.out.println("PROMEDIO SOLTEROS");
        System.out.println(obj.pro1 = obj.cal1 / obj.soltero);
        System.out.println("PROMEDIO CASADOS");
        System.out.println(obj.pro2 = obj.cal2 / obj.casado);
    }

}

class Persona {

    //Definimos los atributos
    private int edad;
    private int estado;//Estado civil
    private int calificacion;

    public Persona(int edad, int estado, int calificacion) {//Constructor del objeto persona
        this.edad = edad;
        this.estado = estado;
        this.calificacion = calificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}

class encuesta {

    int calm = 0, calme = 0, calma = 0;//Suma de las cantidades de edad.
    int cal1 = 0, cal2 = 0;//Suma de las cantidades de estado civil.
    double pro1 = 0, pro2 = 0;//Promedio de los usuarios por estado civil.
    double prom = 0, prome = 0, proma = 0;//Promedio de los usuarios por edad.
    int casado = 0, soltero = 0;//Estado civil
    int menor18 = 0, medio = 0, mayor61 = 0;//edad
    private ArrayList<Persona> bD = new ArrayList();//Creamos el ArrayList para guardar las encuestas que vayamos haciendo.

    public void crearPersona()//método para contar personas
    {
        int edad = this.obEd();
        int estado = this.obEst();
        int calif = this.obCal();

        bD.add(new Persona(edad, estado, calif));//Crear a la persona de acuerdo al constructor de persona

    }

    public void clasificar() {//método para clasificar

        for (int i = 0; i < bD.size(); i++) {
            /*bD.get(i).getEstado();
            bD.get(i).getEdad();
            bD.get(i).getCalificacion();*/
            if (bD.get(i).getEdad() <= 18) {
                System.out.println("MENOR");
                calm = calm + bD.get(i).getCalificacion();
            } else if (bD.get(i).getEdad() >= 19 && bD.get(i).getEdad() <= 60) {
                System.out.println("MEDIO");
                calme = calme + bD.get(i).getCalificacion();
            } else if (bD.get(i).getEdad() > 60) {
                System.out.println("MAYOR");
                calma = calma + bD.get(i).getCalificacion();
            }
            if (bD.get(i).getEstado() == 1) {

                cal1 = cal1 + bD.get(i).getCalificacion();

            } else if (bD.get(i).getEstado() == 2) {

                cal2 = cal2 + bD.get(i).getCalificacion();

            }

        }

    }

    //Definimos los métodos de la encuesta
    public int obEd() {//Obtener la edad
        int edad = 0;
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Escriba su edad");
            edad = teclado.nextInt();
            //bD.add(new Persona(edad,0,0)); Agregar un nuevo objeto sólo con la edad
        } catch (InputMismatchException e) {
            System.out.println("No se introdujo correctamente la edad");
        }
        if (edad >= 0 && edad <= 18) {
            menor18++;
        } else if (edad > 18 && edad <= 60) {
            medio++;
        } else if (edad >= 61) {
            mayor61++;
        }
        return edad;
    }

    public int obEst() {//Obtener estado civil
        int estado = 0;
        
        Scanner teclado = new Scanner(System.in);
        try {//Evitar error
            System.out.println("Estado civil:\n"
                    + "1.-Soltero\n"
                    + "2.-Casado");
            estado = teclado.nextInt();
            switch (estado) {
                case 1:
                    //Soltero
                    soltero++;
                    break;
                case 2:
                    //Casado
                    casado++;
                    break;
                default:
                    System.out.println("No ingresó correctamente el estado civil");//En caso de que se escriba un número mayor.
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("No ingresó correctamente el estado civil");//En caso de que no se escriba un número.
        }
        return estado;
    }

    public int obCal() {//Obtener la calificacion
        int calificacion = 0;
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Del 0 al 10, ¿Cómo califica el curso?");
            calificacion = teclado.nextInt();
            if (!(calificacion >= 0 && calificacion <= 10)) {

                System.out.println("No ingresó correctamente la calificación");
            }
        } catch (InputMismatchException e) {
            System.out.println("No ingresó correctamente la calificación");
        }
        return calificacion;
    }

}
