/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;

/**
 *
 * @author sysadmin
 * @param <T>
 */
public interface IControlador<T,ID> {
    public ArrayList<T> extrerTodo();
    public T extraer(ID id);
    public boolean crear(T entidad);
    public boolean modificar(T entidad);
    public boolean eliminar(T entidad);
}
