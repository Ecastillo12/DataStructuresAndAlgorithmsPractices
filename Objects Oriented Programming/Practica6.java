public class Practica6 {//Sobrecarga de métodos, muchas formas de hacer varios metodos llamados iguales en una misma clase.
    public static void main(String[] args) {
   Operaciones obj = new Operaciones();
   
        System.out.println(obj.sumar("hola", " mundo"));
        //int a = obj.sumar(a);   ///No se puede guardar un método que sale con un void(no regresa nada).
        obj.sumar("hola ");
}
}

class Operaciones{//Condicion para varias clases, donde este el main es public.
    public void sumar(){
        int a = 10, b = 20;
        System.out.println("La suma es igual a: "+a+b);
    }
    //Para que distinga la diferencia es por sus parámetros.
    public void sumar(int a){//El parámetro es diferente.
        System.out.println("La suma es igual a: "+a+a);
    }
    public void sumar(String a){//El parámetro es diferente.
        String x = "Hola";
        x=x+a;
        System.out.println(x);
    }
    public String sumar(String a, String b){//El parámetro es diferente, ¿Por qué necesita un return?
      return a+b;//Valor de retorno*****BUSCAR*****  
    }
}

