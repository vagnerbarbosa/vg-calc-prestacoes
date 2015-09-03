package br.com.lojaoriodopeixe.vg.calc.utils;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Classe contendo métodos que são úteis em determinadas partes do projeto
 *
 * @author Vagner Barbosa (contato@vagnerbarbosa.com)
 *
 * @since 07/06/2015
 *
 * @version 0.9
 */
public class Utils {

    public Utils() {
    }

    public boolean caracterCheck(String value) {
        if (value == null) {
            return false;
        }
        for (char character : value.toCharArray()) {
            if (character == ',') {
                return false;
            }
        }
        return true;
    }

    public void centerWindow(Component frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();

        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }

        frame.setLocation((screenSize.width - frameSize.width) >> 1, (screenSize.height - frameSize.height) >> 1);
    }

    public void nextFieldWithEnter(JFrame frame) {
        // Colocando enter para pular de campo
        HashSet conj = new HashSet(frame.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }

    public void nextFieldWithEnter2(JTextField frame) {
        // Colocando enter para pular de campo
        HashSet conj = new HashSet(frame.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }

    public Image getAImage(String ref) {
        BufferedImage sourceImage = null;

        try {
            URL url = this.getClass().getClassLoader().getResource(ref);
            sourceImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
        return image;
    }
    
    public String Moeda(String valor) {
        try {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
            DecimalFormat df2 = new DecimalFormat("#,##0.00", dfs);
            double d = df2.parse(valor).doubleValue();
            valor = Double.toString(d); // resultado: 1234567.89 
        } catch (ParseException ex) {
            System.out.println("OPA! TEMOS UM PROBLEMA AQUI >>>>>>" + ex.getMessage());
        }

        return valor;
    }    

}
