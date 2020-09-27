
import java.util.ArrayList;
import java.util.Scanner;

/*
 * La aplicación debe permitir registrar al estudiante, 
 * registrarle las 5 Materias a cada Estudiante, 
 * asignar las calificaciones de las materias del estudiante 1.5 a 5,
 * calcular el promedio con aquellas materias que tienen nota
 * e indicar si está en complementación si su promedio es menor a 3.25.
 */
public class Practica17 {
    public static void main(String[] args) {
        Escuela itspa = new Escuela();
        itspa.menu();
        
    }
}

class Escuela {

    private ArrayList<Estudiante> bdEstudiantes = new ArrayList();

    public void menu() {
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println(":::::::::: MENU :::::::::::");
            System.out.println("1.- Alta Alumno  ");
            System.out.println("2.- Alta Materia ");
            System.out.println("3.- Asignar Calificación ");
            System.out.println("4.- Calcular Promedio");
            System.out.println("5.- Revisar Si se encuentra en Complementación");
            System.out.println("6.- Salir");
            System.out.println("OPCION : ");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    //Alta de un Estudiante, como el constructor del
                    //Estudiante requiere de tres datos para su constructor
                    // public Estudiante(int ma, String nom, String ape) hay que
                    //pedirlos al usuario y para que no esté todo programado 
                    // en el case voy a realizar el siguiente método
                    altaEstudiante(leer);
                    break;
                case 2:
                    altaMateria(leer);
                    break;
                case 3:
                    asignarCalificacion(leer);
                    break;
                case 4:
                    calcularPromedio(leer);
                    break;
                case 5:
                    revisarSiComplementacion(leer);
                    break;
                default:
                    System.out.println("Gracias por usar el Sistema");
            }
        } while (opc != 6);
    }
    
   /*
    *Los métodos de esta clase solo son privados, no tiene caso que sean
    *publicos si solo van a ser usados dentro del  
    */ 
   private void revisarSiComplementacion(Scanner leer){
    System.out.println("::::::::::REVISAR SI ESTA EN COMPLEMENTACIÓN:::::::::");
        System.out.println("DATOS A BUSCAR:::::::");
        System.out.println("Matricula del Estudiante (Entero)");
        int matricula = leer.nextInt();
        Estudiante est = buscarEstudiante(matricula);
        if (est != null) { //encontré
            System.out.println("Su estado es " + (est.estudianteEstaComplementacion()? " COMPLEMENTACIÓN ":" NO COMPLEMENTACION "));
        } else {
            System.out.println("NO EXISTE EL ALUMNO");
        }
    }

    private void calcularPromedio(Scanner leer) {
        System.out.println("::::::::::PROMEDIO DE UN ALUMNO:::::::::");
        System.out.println("DATOS A BUSCAR:::::::");
        System.out.println("Matricula del Estudiante (Entero)");
        int matricula = leer.nextInt();
        Estudiante est = buscarEstudiante(matricula);
        if (est != null) {
            System.out.println("Su promedio es de " + est.calcularPromedioEstudiante());
        } else {
            System.out.println("NO EXISTE EL ALUMNO");
        }
    }

    /*
     * Descripción: En este método se pide la matricula del estudiante para 
     * seguido de la clave de la materia a la cual le quieren asignar una calificación 
     * de fin de curso, para que esto suceda debe estar el curso asignado al alumno
     * con anterioridad.
     * Parámetros: Solo recibe el Scanner para ya no declararlo 
     */
    private void asignarCalificacion(Scanner leer) {
        double calif=0.0d;
        System.out.println(":::::::::::ASIGNAR CALIFICACIÓN:::::::::::");
        System.out.println("DATOS A BUSCAR::::::::");
        System.out.println("Matricula del Estudiante (Entero)");
        int matricula = leer.nextInt();
        Estudiante est = buscarEstudiante(matricula);
        if (est != null) { //encuentra al estudiante
            System.out.println("Clave Materia (Cadena)");
            String clave = leer.next();
            Materia ma = est.buscarCurso(clave);
            if (ma != null) //se encuentra la materia
            {
                System.out.println("Calificación de fin de Curso");
                do{
                    calif = leer.nextDouble(); //sigue pidiendo la calif
                                               // hasta que se ponga un número
                                               // entre 1.5 y 5 inclusive.
                }while(!(calif>=1.5d && calif <=5.0));
                ma.setCalificacion(calif);
            } else {
                System.out.println("ESA MATERIA NO ESTÁ ASIGNADA PARA EL ALUMNO");
            }
        } else {
            System.out.println("NO EXISTE EL ALUMNO");
        }
    }

    /*
     * Descripción: En este método se pide la matricula del estudiante para 
     * asignarle un curso, si ya tiene las 5 materias asignadas manda un mensaje
     * que no se pueden agregar otras más
     * Parámetros: Solo recibe el Scanner para ya no declararlo 
     */
    private void altaMateria(Scanner leer) {
        System.out.println("MATRICULA DEL ESTUDIANTE ");
        int matricula = leer.nextInt();
        Estudiante est = buscarEstudiante(matricula);
        if (est != null) {
            if (!est.tieneCursosCompletos()) { //si no ha completado todos sus cursos
                /*se debe pedir clave,nombreMateria y creditos; */
                System.out.println(":::::DATOS DE LA MATERIA::::::");
                System.out.println("Clave: (cadena)");
                String clave = leer.next();
                System.out.println("Nombre: (cadena)");
                String nombreMateria = leer.next();
                System.out.println("Creditos: (entero)");
                int creditos = leer.nextInt();
                est.asignarCurso(new Materia(clave, nombreMateria, creditos));
            } else {
                System.out.println("NO SE PUEDE AGREGAR OTRA MATERIA, YA TIENE 5 ASIGNADAS");
            }
        } else {
            System.out.println("LA MATRICULA NO EXISTE!!!");
        }

    }

    /*
     * Descripción: En este método se piden todos los datos del Estudiante, se
     * realiza un objeto de tipo Estudiante y se envía a la base
     * de datos en memoria.
     * Parámetros: Solo recibe el Scanner para ya no declararlo 
     */
    private void altaEstudiante(Scanner leer) {
        int matricula = 0;
        System.out.println("::::::PROPORCIONAR DATOS DEL ESTUDIANTE :::::::");

        //Este ciclo es para revisar si la matricula existe
        // seguirá pidiendo la matricula hasta que pongan una que no
        //exista
        do {
            System.out.println("Matricula (entero)");
            matricula = leer.nextInt();
        } while (existeEstudiante(matricula));

        System.out.println("Nombre (cadena)");
        String nombre = leer.next();
        System.out.println("Apellidos (cadena)");
        String apellidos = leer.next();
        this.bdEstudiantes.add(new Estudiante(matricula, nombre, apellidos));


    }

    /*
     *Descripción: Este método sirve para revisar de forma secuencial 
     * si un estudiante ya se ha insertado en la base de datos con anterioridad, si 
     * ya existe regresa un true, de lo contrario regresa false.
     * Parámetros: Recibe la matricula a buscar en la base de Datos 
     */
    private boolean existeEstudiante(int matriculaBuscar) {
        boolean existe = false;
        for (int i = 0; i < this.bdEstudiantes.size(); i++) {
            if (this.bdEstudiantes.get(i).getMatricula() == matriculaBuscar) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    /*
     *Descripción: Este método sirve para revisar de forma secuencial 
     * si un estudiante ya se ha insertado en la base de datos con anterioridad, si 
     * ya existe regresa al estudiante, de lo contrario regresa null.
     * Parámetros: Recibe la matricula a buscar en la base de Datos 
     */
    private Estudiante buscarEstudiante(int matriculaBuscar) {
        Estudiante estudiante = null;
        for (int i = 0; i < this.bdEstudiantes.size(); i++) {
            if (this.bdEstudiantes.get(i).getMatricula() == matriculaBuscar) {
                estudiante = this.bdEstudiantes.get(i);
                break;
            }
        }
        return estudiante;
    }
}

class Estudiante {

    private int matricula;
    private String nombre;
    private String apellido;
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;
    private Materia materia4;
    private Materia materia5;

    public Estudiante(int ma, String nom, String ape) {
        this.matricula = ma;
        this.nombre = nom;
        this.apellido = ape;

    }

    /**
     * Método que asigna una materia a un estudiante. El estudiante tiene una
     * nueva materia, si es la quinta materia, el estudiante no puede tener más,
     * así que solo regresa falso. El parametro es la materia a asignar Regresa
     * true si puede asignar la materia y false en caso contrario
     */
    public boolean asignarCurso(Materia materia) {
        if (this.materia1 == null) {
            this.materia1 = materia;

        } else if (this.materia2 == null) {
            this.materia2 = materia;

        } else if (this.materia3 == null) {
            this.materia3 = materia;

        } else if (this.materia4 == null) {
            this.materia4 = materia;

        } else if (this.materia5 == null) {
            this.materia5 = materia;

        } else {
            return false;
        }
        return true;
    }

    /**
     * Método usado para buscar una materia. Descripción: Retorna true si la
     * materia está registrada en las materias del estudiante, false de lo
     * contrario. la busqueda es muy sencilla revisas materia por materia, sin
     * usar for pero si fueran miles de materias claro que no es una por una, se
     * tiene que revisar materia por materia con un ciclo. Parámetro: clave de
     * la materia a buscar - la claveMateria != null Regresa: El Objeto materia
     * si la materia está, null de lo contrario RECUERDE: Un String se compara
     * con el método equals
     */
    public Materia buscarCurso(String claveMateria) {
        if (this.materia1 != null && this.materia1.getClave().equals(claveMateria)) {
            return materia1;
        } else if (this.materia2 != null && this.materia2.getClave().equals(claveMateria)) {
            return materia2;
        } else if (this.materia3 != null && this.materia3.getClave().equals(claveMateria)) {
            return materia3;
        } else if (this.materia4 != null && this.materia4.getClave().equals(claveMateria)) {
            return materia4;
        } else if (this.materia5 != null && this.materia5.getClave().equals(claveMateria)) {
            return materia5;
        } else {
            return null;
        }
    }

    /**
     * Método que calcula el promedio del estudiante. Descripción: Retorna el
     * promedio del estudiante. Retorno:promedio de los cursos vistos por el
     * estudiante - promedio >= 0.0
     */
    public double calcularPromedioEstudiante() {
        double suma = 0.0;
        double promedio = 0.0;
        int totalmaterias = 0; //esta variable llevará el numero
        // de materias que tienen calificación
        if (this.materia1 != null) {
            if (this.materia1.getCalificacion() != 0.0) {
                suma = suma + this.materia1.getCalificacion();
                totalmaterias++;
            }

        }
        if (this.materia2 != null) {
            if (this.materia2.getCalificacion() != 0.0) {
                suma = suma + this.materia2.getCalificacion();
                totalmaterias++;
            }

        }
        if (this.materia3 != null) {
            if (this.materia3.getCalificacion() != 0.0) {
                suma = suma + this.materia3.getCalificacion();
                totalmaterias++;
            }

        }
        if (this.materia4 != null) {
            if (this.materia4.getCalificacion() != 0.0) {
                suma = suma + this.materia4.getCalificacion();
                totalmaterias++;
            }

        }
        if (this.materia5 != null) {
            if (this.materia5.getCalificacion() != 0.0) {
                suma = suma + this.materia5.getCalificacion();
                totalmaterias++;
            }

        }
        // Se asegura que no se generarán problemas por el denominador en cero
        if (totalmaterias > 0) {
            promedio = suma / totalmaterias;
        }

        return promedio;
    }

    /**
     * Indica si el estudiante se encuentra en complementación Regresa true si
     * se encuentra en comple, false de lo contrario
     */
    public boolean estudianteEstaComplementacion() {
        double promedio = calcularPromedioEstudiante();
        if (promedio < 3.25) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Indica si el estudiante tiene todas las materias asignadas. Descripción:
     * Retorna true si los 5 cursos se encuentran asignados o no null, false de
     * lo contrario. Retorna true si los cursos ya estan asignados, false de lo
     * contrario
     */
    public boolean tieneCursosCompletos() {
        if (this.materia1 == null || this.materia2 == null || this.materia3 == null || this.materia4 == null || this.materia5 == null) {
            return false;
        } else {
            return true;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
}

class Materia {

    private String clave;
    private String nombreMateria;
    private int creditos;
    private double calificacion;

    public Materia(String clave, String nombreMateria, int creditos) {
        this.clave = clave;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
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

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}