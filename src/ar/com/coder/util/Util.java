/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.coder.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author sysadmin
 */
public class Util {
    public static final String TITULO_GRABAR_ABM = "Mensaje ABM";
    public static final String MENSAJE_OK_GRABAR = "Los Datos se han grabado correctamente";
    public static final String MENSAJE_ERROR_GRABAR = "Error al Grabar Datos";
    public static final String TITULO_VALIDAR_ERROR = "Error al Validar";
    
    public static <T> Collector<T, ?, T> toSingleton() {
    return Collectors.collectingAndThen(
            Collectors.toList(),
            list -> {
                if (list.size() != 1) {
                    throw new IllegalStateException();
                }
                return list.get(0);
            }
    );
}
    public static final Date convertirFechaString(String fecha) {
        Date fechaFinal = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaFinal = sdf.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);

        }
        return fechaFinal;

    }
    
    public static final String convertirFechaDate(Date fecha){
        String fechaString;
        SimpleDateFormat sdf;
        try{
        sdf = new SimpleDateFormat("dd/MM/yy");
        fechaString=sdf.format(fecha);}
        catch(NullPointerException e){
            fechaString="";
        }
        return fechaString;
    }
    public static final String convertirFechaDateLarga(Date fecha){
        String fechaString;
        SimpleDateFormat sdf;
        try{
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechaString=sdf.format(fecha);}
        catch(NullPointerException e){
            fechaString="";
        }
        return fechaString;
    }
    public String getMac(){
       InetAddress ip;
	try {
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(ip); 
		byte[] mac = network.getHardwareAddress();
		System.out.print("Current MAC address : ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));		
		}
		return sb.toString();
	} catch (UnknownHostException e) {
		e.printStackTrace(); 
	} catch (SocketException e){
		e.printStackTrace(); 
	}
       return null;
   }
    public static long diffFecha(Date fechaInicio,Date FechaFin){
        long diff = FechaFin.getTime() - fechaInicio.getTime();

        return (diff / (1000 * 60 * 60 * 24));
    }
    
    public static java.sql.Date convertirDateEnSqlDate(Date fecha){
        java.sql.Date fechaSql=new java.sql.Date(fecha.getTime());
        return  fechaSql;
    }
    
    public static String quitarNull(String texto){
        if(texto==null){
            return "";
        }
        return texto;
    }

}

