
public class Practica3 {
    public int sumar (int a, int b){
        int c = 0;
        c = a+b;
        return c;
    }
    public int restar (int x, int y){
        int c = 0;
        c = x-y;
        return c;
    }
    public static void main(String[] args) {
        Practica3 obj = new Practica3();
        int y = obj.sumar(10, 5);
        System.out.println(y);
        System.out.println(obj.restar(10, 8));
        System.out.println(obj.restar(10, 8)+obj.sumar(8, 2));
    }
}
