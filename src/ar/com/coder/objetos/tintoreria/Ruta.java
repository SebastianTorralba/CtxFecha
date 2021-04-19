/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import ar.com.coder.objetos.ArticuloProduccion;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class Ruta extends RutaBase {
    private Map<Integer,NodoRutaColor > nodosColor=new HashMap<>();
    

    public NodoRutaColor agregarNodoColor(Integer key, NodoRutaColor value) {
        return nodosColor.put(key, value);
    }
    
    public int sizeNodoColor() {
        return nodosColor.size();
    }

    public NodoRutaColor getNodoColor(Object key) {
        return nodosColor.get(key);
    }

    public NodoRutaColor eliminarNodoColor(Object key) {
        return nodosColor.remove(key);
    }

    public Collection<NodoRutaColor> valoresNodosColor() {
        return nodosColor.values();
    }
    
    
    
   
    
}
