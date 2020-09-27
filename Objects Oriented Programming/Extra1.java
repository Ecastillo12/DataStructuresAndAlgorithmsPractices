/*Se quiere construir un programa que maneje una lista de contactos personales. 
Un contacto tiene nombre, apellido, una dirección, un correo electrónico, 
varios teléfonos y una palabra clave que se utiliza para facilitar su búsqueda.
En el programa de contactos se debe poder (1) agregar un nuevo contacto, (2)
eliminar un contacto ya existente, (3) ver la información detallada de un contacto, 
(4) modificar la información del contacto, (5) mostrar la lista completa de contactos 
y (6) buscar contactos por las palabras claves. 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Extra1 {

    public static void main(String[] args) {
        Agenda agend = new Agenda();
        agend.menu();

    }
}

class Agenda {

    private ArrayList<Contacto> bdContactos = new ArrayList();

    public void menu() {
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println(":::::::::: MENU :::::::::::");
            System.out.println("1.- Agregar contacto");
            System.out.println("2.- Eliminar contacto");
            System.out.println("3.- Ver contacto ");
            System.out.println("4.- Modificar contacto");
            System.out.println("5.- Mostrar contactos");
            System.out.println("6.- Buscar contacto");
            System.out.println("7.- Salir");
            System.out.println("OPCION : ");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    altaContacto(leer);
                    break;
                case 2:
                    eliminarContacto(leer);
                    break;
                case 3:
                    verContacto(leer);
                    break;
                case 4:
                    modificarContacto(leer);
                    break;
                case 5:
                    mostrarContactos();
                    break;
                case 6:
                    buscarContactos();
                    
                    break;
                default:
                    System.out.println("Gracias por usar el Sistema");
            }
        } while (opc != 7);
    }

    /*
    *Los métodos de esta clase solo son privados, no tiene caso que sean
    *publicos si solo van a ser usados dentro del  
     */
    private void altaContacto(Scanner leer) {
        System.out.println("Nombre (cadena)");
        String nombre = leer.next();
        System.out.println("Apellidos (cadena)");
        String apellidos = leer.next();
        System.out.println("Direccion");
        String direccio = leer.next();
        System.out.println("Correo");
        String co = leer.next();
        System.out.println("Cuantos telefonos");
        int n = leer.nextInt();
        String numer[] = new String[n];
        for (int i = 0; i < numer.length; i++) {
            System.out.println("Escriba el telefono");
            numer[i] = leer.next();
        }
        System.out.println("palabra clave");
        String id = leer.next();
        this.bdContactos.add(new Contacto(id, nombre, apellidos, direccio, co, numer));
    }

    private void eliminarContacto(Scanner leer) {
        System.out.println("Elija el contacto a eliminar");
        for (int i = 0; i < bdContactos.size(); i++) {
            System.out.println((i + 1) + ".-" + bdContactos.get(i).getNombre() + " " + bdContactos.get(i).getApellido());
        }
        int n = leer.nextInt();
        bdContactos.remove(n);
    }

    private void modificarContacto(Scanner leer) {
        System.out.println("Elija el contacto a modificar");
        for (int i = 0; i < bdContactos.size(); i++) {
            System.out.println((i + 1) + ".-" + bdContactos.get(i).getNombre() + " " + bdContactos.get(i).getApellido());
        }
        int n = leer.nextInt();
        System.out.println("Palabra clave");
        bdContactos.get(n).setId(leer.next());
        System.out.println("Nombre");
        bdContactos.get(n).setNombre(leer.next());
        System.out.println("Apellidos");
        bdContactos.get(n).setApellido(leer.next());
        System.out.println("Direccion");
        bdContactos.get(n).setDireccion(leer.next());
        System.out.println("Correo");
        bdContactos.get(n).setCorreo(leer.next());
        System.out.println("Cuantos telefonos");
        int nu = leer.nextInt();
        String numer[] = new String[nu];
        for (int i = 0; i < numer.length; i++) {
            System.out.println("Escriba el telefono");
            numer[i] = leer.next();
        }
    }

    private void verContacto(Scanner leer) {
        System.out.println("Cual contacto quiere ver");
        for (int i = 0; i < bdContactos.size(); i++) {
            System.out.println((i + 1) + ".-" + bdContactos.get(i).getNombre() + " " + bdContactos.get(i).getApellido());
        }
        int n = leer.nextInt();
        System.out.println("Nombre:\n" + bdContactos.get(n).getNombre());
        System.out.println("Apellido:\n" + bdContactos.get(n).getApellido());
        System.out.println("Direccion:\n" + bdContactos.get(n).getDireccion());
        System.out.println("Correo:\n" + bdContactos.get(n).getCorreo());
        System.out.println("Numeros:\n" + bdContactos.get(n).getNum().toString());
        System.out.println("Palabra clave\n" + bdContactos.get(n).getId());
    }

    private void mostrarContactos() {
        for (int i = 0; i < bdContactos.size(); i++) {
            System.out.println(bdContactos.get(i).getNombre() + " " + bdContactos.get(i).getApellido());
        }
    }

    private void buscarContactos() {
        Scanner leer =new Scanner(System.in);
        System.out.println("Ingrese la palabra clave");
        String palabra = leer.next();
        String contacto = "";
        for (int i = 0; i < this.bdContactos.size(); i++) {
            if (this.bdContactos.get(i).getId().contains(palabra)) {
                contacto = this.bdContactos.get(i).getNombre()+" "+this.bdContactos.get(i).getApellido();
                break;
            }

        }
        
        System.out.println(contacto);
    }

}

class Contacto {

    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String[] num;

    public String[] getNum() {
        return num;
    }

    public void setNum(String[] num) {
        this.num = num;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Contacto(String id, String nom, String ape, String direccion, String correo, String[] num) {
        this.id = id;
        this.nombre = nom;
        this.apellido = ape;
        this.direccion = direccion;
        this.correo = correo;
        this.num = num;
    }

}
