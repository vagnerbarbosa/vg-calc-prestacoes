package br.com.lojaoriodopeixe.vg.calc.implementations;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe para os objetos do tipo Financing, onde serão contidos os métodos
 * para o mesmo.
 *
 * @author Vagner Barbosa (contato@vagnerbarbosa.com)
 *
 * @since 07/09/2015
 *
 * @version 0.1
 */
public class Financing {

    public Financing() {
    }

    /**
     * Obtém o valor da prestação.
     * @param value Valor a ser financiado
     * @param interest Percentual de juros a que se sujeira o valor presente
     * @param months Quantidade de parcelas do financiamento
     * @param inputValue Valor de entrada a ser abatido do valor do financiamento
     * @return Valor da parcela do financiamento
    **/
    public BigDecimal getInstalment(Double value, Double interest, Integer months, Double inputValue) {
        double realValue = value - inputValue;        
        realValue = (realValue * (interest / 100)) / (1 - (1 / Math.pow(1+(interest/100), months)));        
        BigDecimal preciseValue = new BigDecimal(realValue);
        return preciseValue.setScale(2, RoundingMode.HALF_UP);
    }

}
