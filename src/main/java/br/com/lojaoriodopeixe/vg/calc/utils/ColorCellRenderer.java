package br.com.lojaoriodopeixe.vg.calc.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Guilherme Keller
 */
public class ColorCellRenderer extends DefaultTableCellRenderer {

    public static final int R = 206;
    public static final int G = 255;
    public static final int B = 221;

    private static final long serialVersionUID = 433648737270300478L;
    private static final Log log = LogFactory.getLog(ColorCellRenderer.class);
    private int row = -1;
    private Color color;

    public ColorCellRenderer(Color color, int row) {
        super();
        this.color = color;
        this.row = row;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        if (this.color != null) {
            if (this.row == 4) {
                this.setBackground(this.color);
            }
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    }

    public void validate() {
    }

    public void revalidate() {
    }

}
