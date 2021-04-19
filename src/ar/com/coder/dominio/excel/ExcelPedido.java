/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio.excel;

import ar.com.coder.objetos.PedidoSeguimiento;
import static ar.com.coder.ui.grillas.renders.PedidoGrillaRender.COLOR_AMARILLO;
import static ar.com.coder.ui.grillas.renders.PedidoGrillaRender.COLOR_AZUL;
import static ar.com.coder.ui.grillas.renders.PedidoGrillaRender.COLOR_GRIS;
import static ar.com.coder.ui.grillas.renders.PedidoGrillaRender.COLOR_NARANJA;
import static ar.com.coder.ui.grillas.renders.PedidoGrillaRender.COLOR_ROJO;
import static ar.com.coder.ui.grillas.renders.PedidoGrillaRender.COLOR_VERDE;
import ar.com.coder.util.ExcelGenerador;
import ar.com.coder.util.Util;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author sysadmin
 */
public class ExcelPedido extends ExcelGenerador {

    private XSSFCellStyle estiloVerde;
    private XSSFCellStyle estiloAzul;
    private XSSFCellStyle estiloAmarillo;
    private XSSFCellStyle estiloNaranja;
    private XSSFCellStyle estiloRojo;
    private XSSFCellStyle estiloGris;
    private XSSFCellStyle estiloConNegrita;

    public ExcelPedido() {
        String[] a = {"Pedido Nro", "Fecha Ingreso", "Estado", "Cliente", "Prioridad", "Articulo","Crudo", "Base","Dibujo","Variante/Color", "Cantidad", "Saldo", "Lote/Partida", "Cantidad Lote/Partida", "Cargado sin fecha entrega", "Fecha Entrega", "Fecha Ingreso a Proceso", "Fecha Egreso de Proceso", "Fecha Compromiso", "Fecha Ultimo Despacho", "Cantidad 1°", "Cantidad 2°","Observaciones"};
        this.cabecera = a;
        setFiltroCabecera(Boolean.TRUE);
    }

    @Override
    public Integer renderizarDatos() {
        Integer numeroFila = 1;
        CellStyle estiloFila = estiloBase;
        XSSFCell celda = null;
        for (Iterator<?> it = getDatos().iterator(); it.hasNext();) {
            PedidoSeguimiento ps = (PedidoSeguimiento) it.next();
            XSSFRow fila = getHoja().createRow(numeroFila);
            XSSFRichTextString texto = null;
            int columna = 0;
            estiloFila = establerEstiloFila(ps.getEstado());

            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getIdPedido().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDate(ps.getFechaIngreso()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getEstado());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCliente());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getPrioridad().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCodArticulo());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCodArticuloCrudo());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCodArtBase());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCodDibujo());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCodVarianteColor());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCantidad().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getSaldo().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getNroLote());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCantidadLote().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.isTieneFechaEntregaDeclarada() ? "SI" : "NO");
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDate(ps.getFechaEntrega()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDate(ps.getFechaIngresoProceso()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDate(ps.getFechaEgresoProceso()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDate(ps.getFechaCompromiso()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(Util.convertirFechaDate(ps.getFechaUltimoDespacho()));
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCantidadPrimeraLote().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getCantidadSegundaLote().toString());
            celda.setCellValue(texto);
            celda.setCellStyle(estiloFila);
            celda = fila.createCell(columna++);
            texto = new XSSFRichTextString(ps.getObservacion());
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

        if (estado.toUpperCase().trim().equals("PAR. TERM.")) {
            return estiloVerde;
        }

        if (estado.toUpperCase().trim().equals("PAR. TD33.")) {
            return estiloVerde;
        }

        if (estado.toUpperCase().trim().equals("PARA CONF.")) {
            return estiloVerde;
        }

        if (estado.toUpperCase().trim().equals("EN PROCESO")) {
            return estiloAzul;
        }

        if (estado.toUpperCase().trim().equals("CRUDO DSP+")) {
            return estiloAmarillo;
        }

        if (estado.toUpperCase().trim().equals("TEJIENDO")) {
            return estiloNaranja;
        }

        if (estado.toUpperCase().trim().equals("PENDIENTE")) {
            return estiloRojo;
        }

        if (estado.toUpperCase().trim().equals("PEND SIN CRUDO")) {
            return estiloGris;
        }

        return estiloBase;

    }
}
