
public class Practica2 {
    public void sumar(int a, int b){
        int c=0;
        c= a+b;
        System.out.println("El resultado "+c);
    }
    public void restar(int x, int y){
        int c =0;
        c=x-y;
        System.out.println("El resultado: "+c);
    }
    public static void main(String[] args) {
        Practica2 obj = new Practica2();
        obj.sumar(10, 20);
        Practica2 obj1 = new Practica2();
        obj1.restar(10, 5);
    }
    
}
