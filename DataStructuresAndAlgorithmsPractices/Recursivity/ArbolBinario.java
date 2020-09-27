package Recursividad;
//Contar cuantas hojas tiene el arbol
//Contar cuantos padres tienen dos hijos

public class ArbolBinario {
    
    private int numH;
    private int numP;
    private int numHIzq;
    private int numHDer;
    private Nodo raiz;
    
    public ArbolBinario() {
        this.raiz = null;
    }
    
    public boolean estaVacio() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     r-> raiz
     y-> nodo a comparar*/
    public int compararCon(Nodo r, Nodo y) {
        if (y.getDato() > r.getDato()) {
            //DERECHO
            return 1;
        } else {
            //IZQUIERDO
            return -1;
        }
    }
    //new Nodo(10), la ra�z depende del lado 

    public void insertar(Nodo nodo, Nodo raiz) {
        if (estaVacio()) {
            this.raiz = nodo;
        } else {
            if (this.compararCon(raiz, nodo) == 1) {
                //DERECHA
                if (raiz.getDerecha() == null) {
                    raiz.setDerecha(nodo);
                } else {
                    insertar(nodo, raiz.getDerecha());
                }
                
            } else {
                //IZQUIERDA
                if (raiz.getIzquierda() == null) {
                    raiz.setIzquierda(nodo);
                } else {
                    insertar(nodo, raiz.getIzquierda());
                }
                
            }
        }
    }
    
    public void insertar(Nodo nodo) {
        insertar(nodo, this.raiz);
    }
    
    public void preorden(Nodo r) {
        if (r != null) {
            System.out.println(r.getDato());
            preorden(r.getIzquierda());
            preorden(r.getDerecha());
        }
        
    }
    
    public void inorden(Nodo r) {
        if (r != null) {
            inorden(r.getIzquierda());
            System.out.println(r.getDato());
            inorden(r.getDerecha());
        }
    }
    
    public void postorden(Nodo r) {
        if (r != null) {
            postorden(r.getIzquierda());
            postorden(r.getDerecha());
            System.out.println(r.getDato());
        }
    }
    
    public void contarHojas(Nodo r) {
        if (r != null) {
            if (r.getIzquierda() == null && r.getDerecha() == null) {
                numH++;
            } else {
                contarHojas(r.getIzquierda());
                contarHojas(r.getDerecha());
            }
            
        }
        
    }
    
    public void contarPadres(Nodo r) {
        if (r != null) {
            if (r.getDerecha() != null && r.getIzquierda() != null) {
                numP++;
            }
            contarPadres(r.getDerecha());
            contarPadres(r.getIzquierda());
            
        }
    }
    
    public void contarPadresIzq(Nodo r) {
        if (r != null) {
            if (r.getIzquierda() != null && r.getDerecha() == null) {
                numHIzq++;
            }
            contarPadresIzq(r.getIzquierda());
            contarPadresIzq(r.getDerecha());
        }
    }
    
    public void contarPadresDer(Nodo r) {
        if (r != null) {
            if (r.getDerecha() != null && r.getIzquierda() == null) {
                numHDer++;
            }
            contarPadresDer(r.getIzquierda());
            contarPadresDer(r.getDerecha());
        }
    }
    
    public void Eliminar(Nodo apnodo, int infor) {
        
        Nodo aux = null;
        Nodo aux1 = null;
        boolean BO;
        if(apnodo!=null){
            if(infor<apnodo.getDato()){
                Eliminar(apnodo.getIzquierda(), infor);
            }else{///aqui
                if(infor>apnodo.getDato()){//   111
                    Eliminar(apnodo.getDerecha(), infor);
                }else{
                    Nodo otro = apnodo;
                    if(otro.getDerecha()==null){// 1111
                        apnodo=otro.getIzquierda();
                    }else{
                        if(otro.getIzquierda()==null){//11111----------------|
                            apnodo=otro.getDerecha(); //                     |
                        }else{//                                             |
                            aux=apnodo.getIzquierda();//                     |
                            BO=false;//                                      |
                            while(aux.getDerecha()!=null){//11111.a |        |
                                aux1=aux;
                                aux=aux.getDerecha();
                                BO=true;
                            }//Fin del ciclo del paso 11111.a       |
                            apnodo.setDato(aux.getDato());
                            otro=aux;
                            if(BO==true){//11111.c------------------------|
                                aux1.setDerecha(aux.getIzquierda());//----|
                            }else{//--------------------------------------|
                                apnodo.setIzquierda(aux.getIzquierda());//|
                            }//fin del condicional del paso 11111.c-------|
                        }//fin del condicional del paso 11111----------------|
                    }//fin del condicional del paso 1111
                    //---quitar otro se libera el espacio de memoria----
                    otro=null;
                }//fin del condicional del paso 111
            }//fin del condicional  1.1
        }//fin del condicional 1 
        
         
        
    }
    public void borrarCaso1(Nodo r, int dato){
        if(r!=null){
            if(r.getIzquierda()!=null){
                if(r.getIzquierda().getDato()==dato){
                    r.setIzquierda(null);
                    System.out.println("Izquierda Eliminado");
                }
            }
            if(r.getDerecha()!=null){
                if(r.getDerecha().getDato()==dato){
                    r.setDerecha(null);
                    System.out.println("Derecha Eliminado");
                }
            }
        }
    }
    public void borrarCaso2(Nodo r, int dato){
        if(r!=null){
            if(r.getIzquierda()!=null){
                if(r.getIzquierda().getDato()==dato){
                    if(r.getIzquierda().getIzquierda()!=null && r.getIzquierda().getDerecha()!=null){
                        if(r.getIzquierda().getIzquierda().getDato()>r.getIzquierda().getDerecha().getDato()){
                            r.setIzquierda(r.getIzquierda().getIzquierda());
                            r.getIzquierda().setIzquierda(null);
                        }else{
                            r.setIzquierda(r.getIzquierda().getDerecha());
                            r.getIzquierda().setDerecha(null);
                        }
                    }
                    r.setIzquierda(null);
                    System.out.println("Izquierda Eliminado");
                    return;
                }else{
                    borrarCaso2(r.getDerecha(), dato);
                    borrarCaso2(r.getIzquierda(), dato);
                }
            }
            if(r.getDerecha()!=null){
                if(r.getDerecha().getDato()==dato){
                    r.setDerecha(null);
                    System.out.println("Derecha Eliminada");
                    return;
                }else{
                    borrarCaso2(r.getDerecha(),dato);
                    borrarCaso2(r.getIzquierda(), dato);
                }                
            }
        }
    }
    
    public static void main(String[] args) {
        ArbolBinario arbolito = new ArbolBinario();
        /*
        arbolito.insertar(new Nodo(7));
        arbolito.insertar(new Nodo(3));
        arbolito.insertar(new Nodo(9));
        arbolito.insertar(new Nodo(1));
        arbolito.insertar(new Nodo(4));
        arbolito.insertar(new Nodo(5));
        arbolito.insertar(new Nodo(2));
        arbolito.insertar(new Nodo(6));
        arbolito.insertar(new Nodo(8));
        */
        arbolito.insertar(new Nodo(3));
        arbolito.insertar(new Nodo(2));
        arbolito.insertar(new Nodo(4));
        arbolito.insertar(new Nodo(1));
        arbolito.insertar(new Nodo(2));
        arbolito.Eliminar(arbolito.raiz, 1);
        arbolito.preorden(arbolito.raiz);
    }
}
