package Practica5;

public class Persona {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String edad;
    private String sexo;

    public Persona(String nombre) {//Constructor nombre
        this.nombre = nombre;
    }

    public void cantar() {
        System.out.println("The devil went down to Geoorgia");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Persona(String apellidoP, String apellidoM, String edad) {
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        
    }

    public Persona() {//Constructor que no resiva nada
        this.nombre="Chupitos";
        this.apellidoP="Escobar";
        this.apellidoM="López";
        this.edad="40";
        this.sexo="Femenino";
    }
}
