/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

/**
 *
 * @author sysadmin
 */
public interface ISemaforo<O> {
    public void calcularSemaforizacion(O objeto);
}
