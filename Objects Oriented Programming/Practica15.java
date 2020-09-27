
import java.util.Scanner;

public class Practica15 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        byte t = teclado.nextByte();
        if (t <= 100 && t >= 1) {
            short x = 0;
            for (int i = 0; i < t; i++) {
                x = teclado.nextShort();
                System.out.println(validarDiv5(x));
            }
        }

    }

    public static String validarDiv5(short num) {
        String s = "NOPE";
        if (num % 5 == 0) {
            s = "YEP";
        }
        return s;
    }
}
