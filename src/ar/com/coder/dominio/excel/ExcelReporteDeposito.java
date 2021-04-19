/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio.excel;

import ar.com.coder.objetos.ReporteDeposito;
import ar.com.coder.util.ExcelGenerador;
import ar.com.coder.util.Util;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author sysadmin
 */
public class ExcelReporteDeposito extends ExcelGenerador {

    private XSSFCellStyle estiloVerde;
    private XSSFCellStyle estiloAzul;
    private XSSFCellStyle estiloAmarillo;
    private XSSFCellStyle estiloNaranja;
    private XSSFCellStyle estiloRojo;
    private XSSFCellStyle estiloGris;
    private XSSFCellStyle estiloConNegrita;

    public ExcelReporteDeposito() {
        String[] a = {"Codigo", "Articulo", "ALM", "Prom MES/AÑO", "PROM MES/TM", "CONS. ULT. MES",
            "CONS. ULT. SEM", "ING. MES", "EGR. MES", "Plan", "Dias Proyectados", "Semaforo"};
        this.cabecera = a;
        setFiltroCabecera(Boolean.TRUE);
    }

    @Override
    public Integer renderizarDatos() {
        Integer numeroFila = 1;
        CellStyle estiloFila = estiloBase;
        XSSFCell celda = null;
        for (Iterator<?> it = getDatos().iterator(); it.hasNext();) {
            ReporteDeposito ps = (ReporteDeposito) it.next();
            XSSFRow fila = getHoja().createRow(numeroFila);
            XSSFRichTextString texto = null;
            int columna = 0;
            estiloFila = establerEstiloFila(ps.getSemaforo());

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCodArticulo().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getNomArticulo());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getAlmacenado().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getPromedioUltimoAño().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getPromedioUltimoTrimestre().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getPromedioUltimoMes().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getPromedioUltimaSemana().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getIngresoMesActual().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getEgresoMesActual().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCantidadPlan().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            
            texto = new XSSFRichTextString(String.valueOf(ps.getDiasProyectados()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            
            texto = new XSSFRichTextString(ps.getSemaforo());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            numeroFila++;
        }
        return 0;
    }

    @Override
    protected void inicializarEstilos() {
        super.inicializarEstilos();
        estiloVerde = getLibro().createCellStyle();
        estiloAzul = getLibro().createCellStyle();
        estiloAmarillo = getLibro().createCellStyle();
        estiloNaranja = getLibro().createCellStyle();
        estiloRojo = getLibro().createCellStyle();
        estiloGris = getLibro().createCellStyle();
        estiloVerde.cloneStyleFrom(estiloBase);
        estiloAzul.cloneStyleFrom(estiloBase);
        estiloAmarillo.cloneStyleFrom(estiloBase);
        estiloNaranja.cloneStyleFrom(estiloBase);
        estiloRojo.cloneStyleFrom(estiloBase);
        estiloGris.cloneStyleFrom(estiloBase);
        estiloVerde.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        estiloVerde.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estiloAzul.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        estiloAzul.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estiloAmarillo.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        estiloAmarillo.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estiloNaranja.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        estiloNaranja.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estiloRojo.setFillForegroundColor(IndexedColors.RED.getIndex());
        estiloRojo.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estiloGris.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        estiloGris.setFillPattern(CellStyle.SOLID_FOREGROUND);
    }

    private CellStyle establerEstiloFila(String estado) {
        try {
            if (estado.toUpperCase().trim().equals("VERDE")) {
                return estiloVerde;
            }

            if (estado.toUpperCase().trim().equals("AMARILLO")) {
                return estiloAmarillo;
            }

            if (estado.toUpperCase().trim().equals("ROJO")) {
                return estiloRojo;
            }
        } catch (NullPointerException ex) {
        }
        return estiloBase;

    }
}
