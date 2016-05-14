
package sakila.ui;

import static java.awt.Color.yellow;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
 
/**
 *
 * @author Rolando
 */
public class TablaRenderizador extends JLabel implements TableCellRenderer {

   
    protected int column;

   
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        MiModelo model = (MiModelo) table.getModel();
        this.column=column;
        JCheckBox j=new JCheckBox();

        //La tabla espera un componente, no importa si le envio this(JLabel) u otro
        //Si devuelvo el jlabel podría meter iconos (ver comentarios del final)
        if (value instanceof String)
        {
         Font f = new Font( "Helvetica",Font.ITALIC,12 );
         setFont(f);
         setBackground(getBackground());
         setText(" "+model.getValueAt(row,column).toString());
         setOpaque(true);//para que una etiqueta haga caso del color de fondo
         setBackground(yellow);//amarillo

         return this;
        }
        if (model.getValueAt(row,column).getClass().equals(Boolean.class))
        {
          //j.setOpaque(true);
          j.setBackground(yellow);//amarillo
        j.setSelected(Boolean.parseBoolean(model.getValueAt(row,column).toString()));
          j.setHorizontalAlignment(SwingConstants.CENTER);
          //j.setAlignmentX(j.CENTER_ALIGNMENT);
          return j;
        }
        return this;
    }

   
}


/*******Otro modelo de redenrizador***********/

/*package com.blogspot.rolandopalermo.gui;
 
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
/**
 *
 * @author Rolando
 */
/*
public class TablaRenderizadorCliente implements TableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);
        if (row % 2 == 0) {
            etiqueta.setBackground(new Color(255, 255, 200));
        } else {
            etiqueta.setBackground(Color.white);
        }
        if (column == 1) {
            String nombre = (String) value;
            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            if (nombre.startsWith("#")) { //Hombre
                etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/recursos/user.png"))); // NOI18N
            } else if (nombre.startsWith("&")) { //Mujer
                etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/recursos/user2.png"))); // NOI18N
            }
            etiqueta.setText(value.toString().substring(1, nombre.length()));
        } else {
            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            etiqueta.setText(value.toString());
        }
        if (isSelected) {
            etiqueta.setBackground(new Color(151, 193, 215));
        }
        return etiqueta;
    }
}*/