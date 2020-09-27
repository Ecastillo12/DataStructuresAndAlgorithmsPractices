/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author E_Cas
 */
public class Arbol {

    Nodo raiz;
    int numHojas;
    int numPadres;
    int numPadresIzq;
    int numPadresDer;

    public Arbol() {
        raiz = null;
    }

    //Método para insertar un nodo en el arbol
    public void insertar(int dato, String nom) {
        Nodo nuevo = new Nodo(dato, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            Nodo padre;
            while (true) {
                padre = aux;
                if (dato < aux.dato) {
                    aux = aux.hijoIzquierdo;
                    if (aux == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    aux = aux.hijoDerecho;
                    if (aux == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    //Metodo para recorrer el Arbol inOrden
    public void inorden(Nodo r) {
        if (r != null) {
            inorden(r.hijoIzquierdo);
            System.out.print(r.dato + ", ");
            inorden(r.hijoDerecho);
        }
    }

    public void preorden(Nodo r) {
        if (r != null) {
            System.out.print(r.dato + ", ");
            preorden(r.hijoIzquierdo);
            preorden(r.hijoDerecho);
        }
    }

    public void postorden(Nodo r) {
        if (r != null) {
            postorden(r.hijoIzquierdo);
            postorden(r.hijoDerecho);
            System.out.print(r.dato + ", ");
        }
    }

    public void contarHojas(Nodo r) {
        if (r != null) {
            if (r.hijoIzquierdo == null && r.hijoDerecho == null) {
                numHojas++;
            }
            contarHojas(r.hijoIzquierdo);
            contarHojas(r.hijoDerecho);
        }

    }

    public void contarPadres(Nodo r) {
        if (r != null) {
            if (r.hijoIzquierdo != null && r.hijoDerecho != null) {
                numPadres++;
            }
            contarPadres(r.hijoIzquierdo);
            contarPadres(r.hijoDerecho);
        }
    }

    public void contarPadresIzquierdo(Nodo r) {
        if (r != null) {
            if (r.hijoIzquierdo != null && r.hijoDerecho == null) {
                numPadresIzq++;
            }
            contarPadresIzquierdo(r.hijoIzquierdo);
            contarPadresIzquierdo(r.hijoDerecho);
        }
    }

    public void contarPadresDerecha(Nodo r) {
        if (r != null) {
            if (r.hijoIzquierdo == null && r.hijoDerecho != null) {
                numPadresDer++;
            }
            contarPadresDerecha(r.hijoIzquierdo);
            contarPadresDerecha(r.hijoDerecho);
        }
    }

    public boolean eliminar(int d) {
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean esHijoIzq = true;
        while (aux.dato != d) {
            padre = aux;
            if (d < aux.dato) {
                esHijoIzq = true;
                aux = aux.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return false;
            }
        }//fin del while
        if (aux.hijoDerecho == null && aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = aux.hijoDerecho;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else {
            Nodo reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }

    //Método para devolver el nodo reemplazo
    public Nodo obtenerNodoReemplazo(Nodo nodoReemp) {
        Nodo reemplazarPadre = nodoReemp;
        Nodo reemplazo = nodoReemp;
        Nodo aux = nodoReemp.hijoDerecho;
        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.hijoIzquierdo;
        }
        if (reemplazo != nodoReemp.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemp.hijoDerecho;
        }
        System.out.println("El nodo Reemplazo es " + reemplazo);
        return reemplazo;
    }
    public static void main(String[] args) {
        Arbol  arbolito = new Arbol();
        arbolito.insertar(40, "cuarenta");        
        arbolito.insertar(20, "veinte");        
        arbolito.insertar(60, "sesenta");        
        arbolito.insertar(10, "diez");        
        arbolito.insertar(30, "treinta");        
        arbolito.insertar(50, "cincuenta");        
        arbolito.insertar(70, "setenta");        
        arbolito.insertar(45, "cuarenta y cinco");        
        arbolito.insertar(55, "cincuenta y cinco");        
        arbolito.insertar(54, "cincuenta y cuatro");
        arbolito.preorden(arbolito.raiz);
        arbolito.eliminar(20);
        arbolito.preorden(arbolito.raiz);
    }
}
