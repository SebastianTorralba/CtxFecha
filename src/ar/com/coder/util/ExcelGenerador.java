/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Sebastian
 */
public abstract class ExcelGenerador extends ExcelBase {

    protected String[] cabecera;
    protected XSSFCellStyle estiloBase;
    private XSSFFont fontBase;

    public ExcelGenerador() {
    }

    public ExcelGenerador(List<?> datos) {
        this.datos = datos;
    }

    public abstract Integer renderizarDatos();

    public void renderizarCabecera() {
        XSSFCell celda = null;
        XSSFRow fila = getHoja().createRow(0);
        XSSFRichTextString texto = null;
        for (int columna = 0; columna < cabecera.length; columna++) {
            celda = fila.createCell(columna);
            texto = new XSSFRichTextString(cabecera[columna]);
            celda.setCellValue(texto);
        }

    }

    public void aplicarConfiguracion() {
        if (filtroCabecera ) {
            CellRangeAddress rango = new CellRangeAddress(hoja.getFirstRowNum(), hoja.getLastRowNum(), 0, cabecera.length);
            hoja.setAutoFilter(rango);
        }
    }
public String[] getCabecera() {
        return cabecera;
    }

    public void setCabecera(String[] cabecera) {
        this.cabecera = cabecera;
    }
    public void generarArchivo() {

        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Pedidos");
        inicializarEstilos();
        renderizarCabecera();
        renderizarDatos();
        aplicarConfiguracion();
        try {
            FileOutputStream elFichero = new FileOutputStream("pedidoFechaCompromiso.xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generarArchivo(File archivo) {

        libro = new XSSFWorkbook();
        hoja = libro.createSheet();
        inicializarEstilos();
        renderizarCabecera();
        renderizarDatos();
        aplicarConfiguracion();
        try {
            FileOutputStream elFichero = new FileOutputStream(archivo);
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void inicializarEstilos() {
        estiloBase = getLibro().createCellStyle();
        estiloBase.setBorderRight(CellStyle.BORDER_THIN);
        estiloBase.setRightBorderColor(IndexedColors.BLACK.getIndex());
        estiloBase.setBorderBottom(CellStyle.BORDER_THIN);
        estiloBase.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        estiloBase.setBorderLeft(CellStyle.BORDER_THIN);
        estiloBase.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        estiloBase.setBorderTop(CellStyle.BORDER_THIN);
        estiloBase.setTopBorderColor(IndexedColors.BLACK.getIndex());
        fontBase = getLibro().createFont();
        fontBase.setFontHeightInPoints((short) 10);
        fontBase.setFontName("Arial");
        fontBase.setColor(IndexedColors.BLACK.getIndex());        
        fontBase.setItalic(false);
        estiloBase.setFont(fontBase);
    }
}
