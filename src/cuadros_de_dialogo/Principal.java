
package cuadros_de_dialogo;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {
        
        Ventana A = new Ventana();
        
     //Fin de Programa
    }
    
    //VENTANA -------------------------------------------------------------------------------------------------------
    private static class Ventana extends JFrame {
    
        public Ventana(){
            
            this.setSize(400, 400); this.setLocationRelativeTo(null);
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
           panelOpciones opciones = new panelOpciones();
           
           this.add(opciones, BorderLayout.CENTER);
            
            this.setVisible(true);
        }
        
     //Fin de Clase Ventana
    }
    
 //Fin de Clase Principal
}
