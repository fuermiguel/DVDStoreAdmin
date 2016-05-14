/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakila.ui;

import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class MiModelo extends DefaultTableModel
{

    public MiModelo() {
    }

    MiModelo(Vector tableData, Vector<String> tableHeaders) {
        super(tableData,tableHeaders);
    }
    
    
      public boolean isCellEditable (int row, int column)
   {
       // Aquí devolvemos true o false según queramos que una celda
       // identificada por fila,columna (row,column), sea o no editable
      // if (column == 3)
        //  return true;
       return false;
   }
   /** Primera columna Boolean, segunda Integer y el resto Object */
 
   public Class getColumnClass(int columna)
   {
      if (columna == 3) return Boolean.class;
      if (columna == 4) return Date.class;
      return String.class;
      
   }
}
