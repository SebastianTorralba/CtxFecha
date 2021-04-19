/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio.excel;

import ar.com.coder.objetos.Partida;
import ar.com.coder.util.ExcelLector;
import ar.com.coder.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;

/**
 *
 * @author sysadmin
 */
public class ExcelPartidasLector extends ExcelLector<Partida> {

    private ArrayList<Partida> partidas;

    @Override
    public ArrayList<Partida> extrearDatos() {
        partidas = new ArrayList();
        if (getNombreHoja().isEmpty()) {
            hoja = libro.getSheetAt(1);
        }
        hoja = libro.getSheet(getNombreHoja());

        Iterator<Row> iterator = hoja.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            if (i++ > 8) {
                try {
                    CellReference cellReference = new CellReference("F" + i);
                    Cell CeldaNroLote = nextRow.getCell(cellReference.getCol());
                    String nroLote = Integer.toString(new Double( CeldaNroLote.getNumericCellValue()).intValue());
                    cellReference = new CellReference("AG" + i);
                    Cell Celdafecha = nextRow.getCell(cellReference.getCol());
                    Date fechas = Celdafecha.getDateCellValue();
                    partidas.add(new Partida(nroLote, fechas));
                } catch (IllegalStateException e) {
                    
                } catch (NullPointerException e){
                    System.out.println("Error Null");
                }
                
            }

        }

        setDatos(partidas);
        return partidas;
    }

}
