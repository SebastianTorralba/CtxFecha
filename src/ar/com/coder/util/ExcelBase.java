/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.util;

import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sysadmin
 */
public abstract class ExcelBase {
    
    protected XSSFWorkbook  libro;
    protected XSSFSheet  hoja;
    protected List<?> datos;
    protected Boolean filtroCabecera = false;
    protected String rangoFiltro;

    public ExcelBase() {
    }

    public String getRangoFiltro() {
        return rangoFiltro;
    }

    public void setRangoFiltro(String rangoFiltro) {
        this.rangoFiltro = rangoFiltro;
    }

    public Boolean getFiltroCabecera() {
        return filtroCabecera;
    }

    public void setFiltroCabecera(Boolean filtroCabecera) {
        this.filtroCabecera = filtroCabecera;
    }

    

    public List<?> getDatos() {
        return datos;
    }

    public void setDatos(List<?> datos) {
        this.datos = datos;
    }

    public XSSFWorkbook getLibro() {
        return libro;
    }

    public void setLibro(XSSFWorkbook libro) {
        this.libro = libro;
    }

    public XSSFSheet getHoja() {
        return hoja;
    }

    public void setHoja(XSSFSheet hoja) {
        this.hoja = hoja;
    }

   
    
}
