/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaoriodopeixe.vg.calc.implementations;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author vagner
 */
public class Appteste {
    
    public static void main(String[] args) throws ParseException {
        Financing c = new Financing();
        
        //double resultado = c.getInstalment(1200.0, 3.0, 2, 1180.0);
        //System.out.println(resultado);
        
//        for (int i = 1; i < 10; i++) {
//        if (i > 1) {    
//        System.out.println(i + "º Parcela: " + c.getInstalment(1000d, 5d, i, 50d) + " -- Total Parcelado: " + c.getInstalment(1000d, 5d, i, 50d).multiply(new BigDecimal(i)) + " -- Total Geral: " +
//                c.getInstalment(1000d, 5d, i, 50d).multiply(new BigDecimal(i)).add(new BigDecimal(50))  + "\n");
//        }
//            
//        }
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(c.getCET(51516.515168d, 0.05d, 24, df.parse("01/01/2012"), df.parse("01/02/2012")));
        
        
    }
    
}
