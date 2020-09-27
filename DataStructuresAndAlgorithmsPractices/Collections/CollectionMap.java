package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author E_Cas
 */
public class CollectionMap {

    public static void crearMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.size(); // Devuelve el numero de elementos del Map
        map.put(1, "Lalo"); // Añade un elemento al Map
        map.isEmpty(); // Devuelve true si no hay elementos en el Map y false si si los hay
        map.clear(); // Borra todos los componentes del Map
        map.values(); // Devuelve una "Collection" con los valores del Map
    }

    public static void hacerTreeMap() {
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(1, "Pedro");
        treeMap.put(17, "Fernando");
        treeMap.put(2, "Alonso");
        treeMap.put(9, "Jesus");
        treeMap.put(10, "Carlos");

// Imprimimos el Map con un Iterador instanciado
        Iterator it = treeMap.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            System.out.println("Clave: " + key + " Valor: " + treeMap.get(key));
        }
    }
    public static void main(String[] args) {
        hacerTreeMap();
    }
}
