/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaoriodopeixe.vg.calc.implementations;

import java.math.BigDecimal;

/**
 *
 * @author vagner
 */
public class Appteste {
    
    public static void main(String[] args) {
        Financing c = new Financing();
        
        for (int i = 1; i < 10; i++) {
        if (i > 1) {    
        System.out.println(i + "º Parcela: " + c.getInstalment(1000d, 5d, i, 0d) + " -- Total Parcelado: " + c.getInstalment(1000d, 5d, i, 0d).multiply(new BigDecimal(i)) + " -- Total Geral: " +
                c.getInstalment(1000d, 5d, i, 250d).multiply(new BigDecimal(i)).add(new BigDecimal(250))  + "\n");
        }
            
        }
        
        
    }
    
}
