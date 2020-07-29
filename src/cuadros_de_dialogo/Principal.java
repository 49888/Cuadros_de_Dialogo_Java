
package cuadros_de_dialogo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal {

    public static void main(String[] args) {
        
        Ventana A = new Ventana();
        
     //Fin de Programa
    }
    
    //VENTANA -------------------------------------------------------------------------------------------------------
    private static class Ventana extends JFrame {
    
        public Ventana(){
            
            this.setSize(700, 400); this.setLocationRelativeTo(null);
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            
            //PANEL DE OPCIONES
                panelOpciones opciones = new panelOpciones();

                this.add(opciones, BorderLayout.CENTER);
            
                
            //OYENTE PRICIPAL DE EVENTOS
                Eventos A = new Eventos(opciones);
            
                
            //PANEL INFERIOR
                JButton mostrar = new JButton("Mostrar");
                
                    mostrar.addActionListener(new ActionListener(){
                        
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            A.mostrar();
                        }
                    });
        
                JButton salir = new JButton("Salir");
        
                    salir.addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    
                JPanel panelInferior = new JPanel();
                panelInferior.add(mostrar); panelInferior.add(salir);
                
                this.add(panelInferior, BorderLayout.SOUTH);
            
            
            this.setVisible(true);
        }
        
     //Fin de Clase Ventana
    }
    
 //Fin de Clase Principal
}
