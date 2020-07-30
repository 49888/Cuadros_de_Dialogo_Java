
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Opcion {
    
    public Box getOpcion(){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox cadenas = new JCheckBox("String[]");
        JCheckBox iconos = new JCheckBox("Icon[]");
        JCheckBox objetos = new JCheckBox("Object[]");

        
        grupo.add(cadenas); grupo.add(iconos); grupo.add(objetos); 
        
        caja.add(cadenas); caja.add(iconos); caja.add(objetos);
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, "Opcion"));
        
        return(caja);
    }
    
 //Fin de Clase Opcion
}
