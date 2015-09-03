package br.com.lojaoriodopeixe.vg.calc.utils;

import java.awt.Color;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe para criar campos formatados com valores em decimal Tanto para valores
 * simples, como para exibir máscaras monetárias ou porcentagem
 *
 * @author Sekkuar
 *
 */
public class DecimalFormattedField extends JFormattedTextField {

    /**
     * Constantes para definir o formato
     */
    //public static final String NUMERO = "#,##0.00; -#,##0.00";  
    public static final String NUMERO = "###0; -###0";
    //public static final String REAL = "R$ #,##0.00;R$ -#,##0.00";  
    public static final String REAL = "#,##0.00;-#,##0.00";
    public static final String PORCENTAGEM = "#,##0.00'%';-#,##0.00'%'";

    private static final Currency currency = Currency.getInstance("BRL");
    private static final DecimalFormat formato = new DecimalFormat("#,##0.00");

    /**
     * Formato sendo utilizado
     */
    private DecimalFormat df;

    /**
     * Valor inserido no campo
     */
    private double dValue = 0.0;

    /**
     * Ultimo valor válido
     */
    private String oldValue = "0.00";

    /**
     * String que será exibida em caso de valor inválido ou fora do formato
     */
    public static final String ERRO = "Valor inválido";

    /**
     * Cria um novo objeto DecimalFormattedField, com o formato especificado
     *
     * @param formato Uma String que será o formato (pattern) do DecimalFormat a
     * ser utilizado
     */
    public DecimalFormattedField(String formato) {
        super();

        df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.UP);
        df.applyPattern(formato);

        this.setHorizontalAlignment(JTextField.RIGHT);

        setValue(oldValue);
        applyActions();
    }

    /**
     * Aplica um novo DecimalFormat
     */
    public void setDf(DecimalFormat df) {
        this.df = df;
        setValue("0.00");
        this.thisFocusGained(null);
        setText("0.00");
    }

    /**
     * Retorna o DecimalFormat sendo usado atualmente
     */
    public DecimalFormat getDf() {
        return df;
    }

    /**
     * Cria as ações de focus para setar e verificar os valores digitados
     */
    private void applyActions() {

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //transferFocus();  
            }
        });

        this.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent evt) {
                thisFocusLost(evt);
            }

            @Override
            public void focusGained(FocusEvent evt) {
                thisFocusGained(evt);
            }
        });

    }

    /**
     * Verifica se o valor digitado é válido, e insere os novos valores
     */
    public void thisFocusLost(FocusEvent evt) {
        String valor = this.Moeda(getText().replace("%", ""));
        System.out.println("O valor em thisFocusLost é: " + valor);
        if (!valor.equals("") && !valor.trim().isEmpty()) {
            oldValue = valor;
        }
        setValue(valor);
    }

    /**
     * Limpa o campo para que seja digitado novo valor
     */
    public void thisFocusGained(FocusEvent fe) {
        //super.setText("");  
        super.selectAll();
        normalText();
    }

    /**
     * Seta os valores no campo
     */
    private void setValue(String value) {
        try {
            dValue = arredondar(Double.parseDouble(value));
        } catch (Exception e) {
            /**
             * Aqui o valor é inválido, então coloca novamente o valor antigo
             */
            value = oldValue;
        }
        showValue(value);
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Double) {
            double d = (Double) value;
            this.setText(String.format("%f", d));
        } else {
            this.setText(value.toString());
        }
    }

    /**
     * Mostra o valor formatado no padrão do DecimalFormat
     *
     * @param s valor informado no campo
     */
    public void showValue(String s) {
        try {
            super.setText(df.format(new java.math.BigDecimal(s)));
        } catch (Exception e) {
            /**
             * Valor inválido, exibe mensagem de erro
             */
            error();
            dValue = Double.NaN;
        }
    }

    /**
     * Retorna o valor inserido no campo.
     *
     * @return dValue double value
     */
    public double getDoubleValue() {
        return dValue;
    }

    @Override
    public Object getValue() {
        return getDoubleValue();
    }

    /**
     * Mostra o texto ERRO em vermelho.
     */
    private void error() {
        this.setForeground(Color.red);
        super.setText(ERRO);
    }

    /**
     * Volta o texto ao formato original
     */
    private void normalText() {
        this.setForeground(null);
    }

    @Override
    public void setText(String valor) {
        super.setText(valor);
        this.thisFocusLost(null);
    }

    /**
     * Arredondamento para corrigir possíveis diferenças em decimal do valor
     * exibido com o valor retornado
     */
    public double arredondar(double d) {
        if (d > 0) {
            return (Math.ceil((d * 100.0))) / 100.0;
        } else {
            return (Math.floor((d * 100.0))) / 100.0;
        }
    }

    //Converte uma String monetária para o formato double
    public String Moeda(String valor) {
        try {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
            DecimalFormat df2 = new DecimalFormat(NUMERO, dfs);
            double d = df2.parse(valor).doubleValue();
            valor = Double.toString(d); // resultado: 1234567.89 
        } catch (ParseException ex) {
            //System.out.println("OPA! TEMOS UM PROBLEMA AQUI >>>>>>" + ex.getMessage());
        }

        return valor;
    }

}
