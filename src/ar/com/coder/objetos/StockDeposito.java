/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;

import java.util.ArrayList;

/**
 *
 * @author sysadmin
 */
public class StockDeposito {
    private Deposito deposito;
    private ArrayList<Stock> items;

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public int size() {
        return items.size();
    }

    public Stock getItem(int index) {
        return items.get(index);
    }

    public boolean addItem(Stock e) {
        return items.add(e);
    }

    public void clear() {
        items.clear();
    }

    public boolean contains(Object o) {
        return items.contains(o);
    }
    
    
    
    
    
}
