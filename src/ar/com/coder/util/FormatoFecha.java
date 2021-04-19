/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.coder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author sysadmin
 */
public class FormatoFecha extends MaskFormatter {
    private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yy kk:mm:ss");
    public FormatoFecha() throws ParseException {
        super("##/##/## ##:##:##");
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if(value instanceof Date){
            return formato.format((Date)value);
        }
        return formato.format(new Date());
    }

    @Override
    public Object stringToValue(String value) throws ParseException {
        return formato.parseObject(value);
    }
    
    
}
