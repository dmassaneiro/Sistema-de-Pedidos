/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.ferramentas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lizze
 */
public class MinhasDatas{
//aqui eu converto a data pra ano/mes/dia
 public String formataDataRetornaBD(String data) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d = df.parse(data);
        df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(d);
        return s;
    }
//aqui eu converto para dia/mes/ano
public String formataDataExibe(String data) throws ParseException{        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(data);
        df = new SimpleDateFormat("dd/MM/yyyy");
        String s = df.format(d);
        return s;
    }
}