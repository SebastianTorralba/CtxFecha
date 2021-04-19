/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio.excel;

import ar.com.coder.dominio.ArticuloControlador;
import ar.com.coder.objetos.ReporteQuimico;
import ar.com.coder.util.ExcelGenerador;
import ar.com.coder.util.Util;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ExcelReporteQuimicoConsumo extends ExcelGenerador {

    private XSSFCellStyle estiloVerde;
    private XSSFCellStyle estiloAzul;
    private XSSFCellStyle estiloAmarillo;
    private XSSFCellStyle estiloNaranja;
    private XSSFCellStyle estiloRojo;
    private XSSFCellStyle estiloGris;
    private XSSFCellStyle estiloConNegrita;

    public ExcelReporteQuimicoConsumo() {
        String[] a = {"CODIGO", "PRODUCTO", "FECHA", "CANTIDAD", "UNIDAD", "MAQUINA", "MODO", "BARCADA", "ARTICULO", "PESO", "METROS", "PARTIDAS", "COLOR", "TIPO", "RECETA"};
        this.cabecera = a;
        setFiltroCabecera(Boolean.TRUE);
    }

    @Override
    public Integer renderizarDatos() {
        Integer numeroFila = 1;
        CellStyle estiloFila = estiloBase;
        XSSFCell celda = null;
        for (Iterator<?> it = getDatos().iterator(); it.hasNext();) {
            ReporteQuimico ps = (ReporteQuimico) it.next();
            XSSFRow fila = getHoja().createRow(numeroFila);
            XSSFRichTextString texto = null;
            int columna = 0;

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getProducto().getCodigo());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getProducto().getNombre());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDateLarga(ps.getFecha()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(String.valueOf(ps.getCantidad()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getUnidad());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            try {
                texto = new XSSFRichTextString(ps.getMaquina().toString());
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                texto = new XSSFRichTextString("");
            }

            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getModo().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            if (ps.getModo().equals("PROGRAMADA")) {
                texto = new XSSFRichTextString(ps.getBarcada().getNumero().toString());
            } else {
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            if (ps.getModo().equals("PROGRAMADA")) {
                texto = new XSSFRichTextString(ps.getBarcada().getArticulo().toString());
            } else {
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            if (ps.getModo().equals("PROGRAMADA")) {
                texto = new XSSFRichTextString(ps.getBarcada().getPeso().toString());
            } else {
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            if (ps.getModo().equals("PROGRAMADA")) {
                texto = new XSSFRichTextString(ps.getBarcada().getMetros().toString());
            } else {
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            try {

                texto = new XSSFRichTextString(ps.getBarcada().getPartida().toString());
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);

            celda = fila.createCell(columna++);
            try {

                texto = new XSSFRichTextString(ps.getBarcada().getColor().toString());
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                texto = new XSSFRichTextString("");
            }

            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            try {

                texto = new XSSFRichTextString(ps.getBarcada().getTipo().toString());
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            try {

                texto = new XSSFRichTextString(ps.getBarcada().getReceta().getCodigo().toString());
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                texto = new XSSFRichTextString("");
            }
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);

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
