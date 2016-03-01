package br.com.lojaoriodopeixe.vg.calc.implementations;

import br.com.lojaoriodopeixe.vg.calc.utils.Utils;
import java.text.ParseException;

/**
 *
 * @author vagner
 */
public class Appteste {
    
    public static void main(String[] args) throws ParseException {
        Financing c = new Financing();
//        System.out.println(c.getRealCET(2.92));

        Utils u = new Utils();
       // System.out.println(u.Moeda("1.1561,58"));

        
      
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
        
        System.out.println(":::::: " + c.getReverseInstalment(1000.00d, 1.0, 12, 0.0d));
    }
    
}
