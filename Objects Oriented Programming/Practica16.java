import java.util.ArrayList;
import java.util.Scanner;
/*Se quiere construir una aplicación para el manejo de cursos de un estudiante, los datos personales del estudiante son nombre,
 apellido y matrícula. el estudiante toma sólo cinco cursos en el semestre. Cada uno de los cursos tiene nombre, código,
 número de créditos. Al finalizar el curso, al estudiante se le asigna una calificación que está entre 1.5 y 5. El estudiante
 presenta complementación si su promedio es inferior a 3.25, la aplicación debe permitir registrar estudiantes, registrar los
 5 cursos o materias de cada estudiante asignar calificaciones a cada curso, calcular el promedio sólo de aquellas 
 materias que tienen una calificación, e indicar si está en complementación o no.*/
public class Practica16 {

    public static void main(String[] args) {
        int select = -1;
        
        ArrayList<Alumno> bDA = new ArrayList();
        ArrayList<Curso> bDM = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        while (select != 0) {
            System.out.println("::::::MENU:::::::\n"
                    + "1.-Registrar estudiante\n"
                    + "2.-Registrar materia\n"
                    + "3.-Asignar calificaciones\n"
                    + "4.-Calcular promedio\n"
                    + "0.-Salir");
            select = teclado.nextInt();
            switch (select) {//Switch de menu principal
                case 1://Registrar un alumno:
                    
                    System.out.println("Escriba el nombre:");
                    String nom = teclado.next().trim().toUpperCase();
                    System.out.println("Escriba el apellido");
                    String ape = teclado.next().trim().toUpperCase();
                    System.out.println("Escriba la matrícula");
                    int matri = teclado.nextInt();
                    bDA.add(new Alumno(nom, ape, matri));
                    break;
                case 2://Registrar materia:
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Escriba el nombre del curso" + i);
                        String n = teclado.next().trim().toUpperCase();
                        System.out.println("Escriba el codigo");
                        int co = teclado.nextInt();
                        System.out.println("Escriba el numero de créditos");
                        int cr = teclado.nextInt();
                        bDM.add(new Curso(n, co, cr));
                    }
                    break;
                case 3://Asignar calificación
                    int matricula = Alumno.buscarAlumno();//definir la matricula como el entero del método
                    for (int i = 0; i < bDA.size(); i++) {//Buscar por la base de datos de alumnos
                        if(bDA.get(i).getMatricula()==matricula){
                            int codigo = Curso.buscarCurso();
                            for (int j = 0; j < bDM.size(); j++) {
                                if(bDM.get(i).getCódigo()==codigo){
                                    Curso.asignarCalificacion();
                                }
                            }
                        }
                    }
                    break;
                case 4://Calcular promedio
                    

                    break;
                default:
                    System.out.println("Adiós!!!!!!");
                    break;
            }
        }
    }

}
class Alumno {
    //Atributos del alumno
    private String nombre;
    private String apellido;
    private int matricula;

    public Alumno(String nom, String ape, int mat) {
        this.nombre = nom;
        this.apellido = ape;
        this.matricula = mat;

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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public static int buscarAlumno() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escriba la matrícula del alumno");
        int n = input.nextInt();
        
        return n;
    }
    public static int buscarMateria(){
        Scanner input = new Scanner (System.in);
        System.out.println("Escriba el código de la materia:");
        int co = input.nextInt();
        return co;
    }
    public static int ingresarCal(){
        Scanner input = new Scanner (System.in);
        System.out.println("Ingrese la calificación de la materia:");
        int cal = input.nextInt();
        return cal;
    }
}

class Curso {

    //Atributos del curso
    private String nombre;
    private int código;
    private int creditos;
    private double calificacion;

    public Curso(String nom, int co, int cre) {
        this.nombre = nom;
        this.código = co;
        this.creditos = cre;

    }
    public static int buscarCurso(){
        Scanner input = new Scanner(System.in);
        System.out.println("Escriba el código del curso");
        int co = input.nextInt();
        return co;
    }
    public static double asignarCalificacion(){
        Scanner input = new Scanner(System.in);
        System.out.println("Escriba la calificación del alumno");
        double calif = input.nextDouble();
        return calif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
