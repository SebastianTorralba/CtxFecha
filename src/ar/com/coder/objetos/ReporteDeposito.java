/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;

/**
 *
 * @author sysadmin
 */
public class ReporteDeposito {
    private String codArticulo ;
    private String codTipoArt;
    private String nomArticulo;
    private String esImportado;
    private Float almacenado;
    private Float transito;
    private Float cantidadOrdenCompra;
    private Float ultimoPrecio;
    private String monenda;
    private Float promedioUltimoAño;
    private Float promedioUltimoMes;
    private Float promedioUltimoTrimestre;
    private Float promedioUltimaSemana;
    private Float ingresoMesActual;
    private Float egresoMesActual;
    private Float cantidadPlan;
    private String semaforo;
    private int diasProyectados;

    public int getDiasProyectados() {
        return diasProyectados;
    }

    public void setDiasProyectados(int diasProyectados) {
        this.diasProyectados = diasProyectados;
    }
    
    public String getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(String semaforo) {
        this.semaforo = semaforo;
    }
    
    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getCodTipoArt() {
        return codTipoArt;
    }

    public void setCodTipoArt(String codTipoArt) {
        this.codTipoArt = codTipoArt;
    }

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public String getEsImportado() {
        return esImportado;
    }

    public void setEsImportado(String esImportado) {
        this.esImportado = esImportado;
    }

    public Float getAlmacenado() {
        return almacenado;
    }

    public void setAlmacenado(Float almacenado) {
        this.almacenado = almacenado;
    }

    public Float getTransito() {
        return transito;
    }

    public void setTransito(Float transito) {
        this.transito = transito;
    }

    public Float getCantidadOrdenCompra() {
        return cantidadOrdenCompra;
    }

    public void setCantidadOrdenCompra(Float cantidadOrdenCompra) {
        this.cantidadOrdenCompra = cantidadOrdenCompra;
    }

    public Float getUltimoPrecio() {
        return ultimoPrecio;
    }

    public void setUltimoPrecio(Float ultimoPrecio) {
        this.ultimoPrecio = ultimoPrecio;
    }

    public String getMonenda() {
        return monenda;
    }

    public void setMonenda(String monenda) {
        this.monenda = monenda;
    }

    public Float getPromedioUltimoAño() {
        return promedioUltimoAño;
    }

    public void setPromedioUltimoAño(Float promedioUltimoAño) {
        this.promedioUltimoAño = promedioUltimoAño;
    }

    public Float getPromedioUltimoMes() {
        return promedioUltimoMes;
    }

    public void setPromedioUltimoMes(Float promedioUltimoMes) {
        this.promedioUltimoMes = promedioUltimoMes;
    }

    public Float getPromedioUltimoTrimestre() {
        return promedioUltimoTrimestre;
    }

    public void setPromedioUltimoTrimestre(Float promedioUltimoTrimestre) {
        this.promedioUltimoTrimestre = promedioUltimoTrimestre;
    }

    public Float getPromedioUltimaSemana() {
        return promedioUltimaSemana;
    }

    public void setPromedioUltimaSemana(Float promedioUltimaSemana) {
        this.promedioUltimaSemana = promedioUltimaSemana;
    }

    public Float getIngresoMesActual() {
        return ingresoMesActual;
    }

    public void setIngresoMesActual(Float ingresoMesActual) {
        this.ingresoMesActual = ingresoMesActual;
    }

    public Float getEgresoMesActual() {
        return egresoMesActual;
    }

    public void setEgresoMesActual(Float egresoMesActual) {
        this.egresoMesActual = egresoMesActual;
    }

    public Float getCantidadPlan() {
        return cantidadPlan;
    }

    public void setCantidadPlan(Float cantidadPlan) {
        this.cantidadPlan = cantidadPlan;
    }
    
    
}
