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
public class PartidaComparada {
    private Partida partidaNodum;
    private Partida partidaExcel;

    public PartidaComparada(Partida partidaNodum, Partida partidaExcel) {
        this.partidaNodum = partidaNodum;
        this.partidaExcel = partidaExcel;
    }

    public Partida getPartidaNodum() {
        return partidaNodum;
    }

    public void setPartidaNodum(Partida partidaNodum) {
        this.partidaNodum = partidaNodum;
    }

    public Partida getPartidaExcel() {
        return partidaExcel;
    }

    public void setPartidaExcel(Partida partidaExcel) {
        this.partidaExcel = partidaExcel;
    }
    
}
