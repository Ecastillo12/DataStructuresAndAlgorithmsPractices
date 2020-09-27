import java.util.ArrayList;
import java.util.Scanner;


public class CasoFinal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Club c = new Club();
        Socios soc = new Socios(" ", " ");
        Facturas fac = new Facturas("", "", 0);

        byte opc = 2;
        while (opc != 0) {
            System.out.println(":_:_:_:_MENU_:_:_:_:\n"
                    + "1.-Afiliar socio\n"
                    + "2.-Aumentar consumo a un socio\n"
                    + "3.-Pagar consumos o facturas(Buscando al socio)\n"
                    + "4.-Ver cuenta de un ");
            opc = leer.nextByte();
            switch (opc) {
                case 1:
                    System.out.println("Nombre");
                    String nombre = leer.next();

                    System.out.println("Escribe una cedula");
                    String cedula = leer.next();
                    c.afiliarSocio(nombre, cedula);
                    break;

                case 2:
                    System.out.println("INGRESAR DATOS DEL SOCIO");
                    System.out.println("Ingrese cédula del socio");
                    cedula = leer.next();
                    System.out.println("INGRESAR DATOS DEL CONSUMO");
                    System.out.println("Ingresar ID del servicio o producto");
                    String Id = leer.next();
                    System.out.println("Concepto del servicio o producto");
                    String concepto = leer.next();
                    System.out.println("$ Valor $");
                    double valor = leer.nextDouble();
                    c.registrarconsumo(cedula, Id, concepto, valor);

                    break;
                case 3:
                    System.out.println("Ingrese la cédula del socio");
                    cedula = leer.next();

                    c.verCuenta(cedula);

                    c.pagarFACTURA(cedula);
                    break;

                case 4:
                    System.out.println("Ingrese la cedula del socio");
                    cedula = leer.next();
                    c.verCuenta(cedula);

                    break;

            }

        }

    }
}

class Club {

    private ArrayList socios;

    public Club() {
        socios = new ArrayList();
    }

    public ArrayList getSocios() {
        return socios;
    }

    public void setSocios(ArrayList socios) {
        this.socios = socios;
    }

    public void afiliarSocio(String nombre, String cedula) {
        if (socios.size() > 0) {
            for (int i = 0; i < socios.size(); i++) {
                Socios d = (Socios) socios.get(i);
                if (d.getCedula().equals(cedula)) {
                    System.out.println("Cédula existente\n");

                } else {
                    Socios nuevo = new Socios(nombre, cedula);
                    socios.add(nuevo);
                    System.out.println("AFILIADO\n");
                    break;
                }
            }
        } else {
            Socios nuevo = new Socios(nombre, cedula);
            socios.add(nuevo);
            System.out.println("AFILIADO\n");
        }

    }

    public void pagarFACTURA(String cedula) {
        for (int i = 0; i < socios.size(); i++) {
            Socios d = (Socios) socios.get(i);
            if (d.getCedula().equals(cedula)) {

                d.pagarfacturas();

            } else {
                System.out.println("NO EXISTE EL SOCIO, INTENTE DE NUEVO\n");
                break;
            }
        }
    }

    public void registrarconsumo(String cedula, String id, String concepto, double valor) {
        for (int i = 0; i < socios.size(); i++) {
            Socios d = (Socios) socios.get(i);
            if (d.getCedula().equals(cedula)) {
                d.registrarF(id, concepto, valor);
                System.out.println("REGISTRADO\n");
                break;
            } else {
                System.out.println("NO EXISTE EL SOCIO, INTENTE DE NUEVO\n");
                break;
            }
        }

    }

    public void verCuenta(String cedula) {
        for (int i = 0; i < socios.size(); i++) {
            Socios d = (Socios) socios.get(i);
            if (d.getCedula().equals(cedula)) {
                d.verC();
            } else {
                System.out.println("NO EXISTE EL SOCIO, INTENTE DE NUEVO\n");
                break;
            }
        }

    }

}

class Socios {

    Scanner leer = new Scanner(System.in);

    private String nombre;
    private String cedula;
    private ArrayList facturas;

    public void registrarF(String id, String concepto, double valor) {
        Facturas f = (new Facturas(id, concepto, valor));
        facturas.add(f);
    }

    public void pagarfacturas() {
        if (facturas.size() >= 1) {
            System.out.println("SELECCIONE NO. DE FACTURA (>=0)");
            int x = new Scanner(System.in).nextInt();
            facturas.remove(x);
            System.out.println("PAGADA\n");
        } else {
            System.out.println("NO HAY CONSUMOS EN ESTA CUENTA\n");
        }
    }

    public void verC() {
        if (facturas.size() >= 1) {
            for (int i = 0; i < facturas.size(); i++) {
                System.out.println("NO. DE FACTURA" + i + " CONCEPTO Y COSTO:  " + facturas.get(i) + "  NO PAGADA\n");
            }
        } else {
            System.out.println("CUENTA VACÍA\n");

        }
    }

    public Scanner getLeer() {
        return leer;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public ArrayList getFacturas() {
        return facturas;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setFacturas(ArrayList facturas) {
        this.facturas = facturas;
    }

    public Socios(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.facturas = new ArrayList();
    }

}

class Facturas {

    private String id;
    private String concepto;
    private double valor;

    public void setId(String id) {
        this.id = id;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getValor() {
        return valor;
    }

    public Facturas(String id, String concepto, double valor) {
        this.id = id;
        this.concepto = concepto;
        this.valor = valor;
    }

    public String toString() {
        String factura = concepto + "    $" + valor;
        return factura;
    }

}
