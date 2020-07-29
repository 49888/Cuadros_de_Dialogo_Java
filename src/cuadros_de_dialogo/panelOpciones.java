
package cuadros_de_dialogo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class panelOpciones extends JPanel{
    
    public panelOpciones(){
    
        GridLayout layout = new GridLayout(2, 3);

        this.setLayout(layout);
        
        this.add(tipo());
    }
    
    
    private Box tipo(){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox message = new JCheckBox("Mensaje: showMessageDialog");
        JCheckBox input = new JCheckBox("Entrada: showInputDialog");
        JCheckBox confirm = new JCheckBox("Confirmar: showConfirmDialog");
        JCheckBox option = new JCheckBox("Opcion: showOptionDialog");
        
        grupo.add(message); grupo.add(input); grupo.add(confirm); grupo.add(option);
        
        caja.add(message); caja.add(input); caja.add(confirm); caja.add(option);
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, "Tipo de Mensaje"));
        
        return(caja);
    }
    
 //Fin de Clase panelOpciones  
}
