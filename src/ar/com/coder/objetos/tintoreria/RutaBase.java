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
public class RutaBase {
    
    protected ArticuloProduccion articulo;
    protected Map<Integer, NodoRuta> nodos = new HashMap<>();

    public ArticuloProduccion getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloProduccion articulo) {
        this.articulo = articulo;
    }

    public int sizeNodos() {
        return nodos.size();
    }

    public NodoRuta getNodo(Object key) {
        return nodos.get(key);
    }

    public Collection<NodoRuta> valoresNodos() {
        return nodos.values();
    }

    public boolean eliminarNodo(Object key, Object value) {
        return nodos.remove(key, value);
    }

    public NodoRuta agregarNodo(Integer key, NodoRuta value) {
        return nodos.put(key, value);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.articulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ruta other = (Ruta) obj;
        if (!Objects.equals(this.articulo, other.articulo)) {
            return false;
        }
        return true;
    }
    
}
