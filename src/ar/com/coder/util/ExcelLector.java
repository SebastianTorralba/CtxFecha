/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sysadmin
 */
public abstract class ExcelLector<T> extends ExcelBase{
    private String nombreHoja="";

    public String getNombreHoja() {
        return nombreHoja;
    }

    public void setNombreHoja(String nombreHoja) {
        this.nombreHoja = nombreHoja;
    }
    
    public Boolean cargarArchivo(File archivo){
        FileInputStream fis;
        try {
            fis = new FileInputStream(archivo);
            setLibro(new XSSFWorkbook(fis));
                        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelLector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {            
            Logger.getLogger(ExcelLector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public abstract ArrayList<T> extrearDatos();
}
