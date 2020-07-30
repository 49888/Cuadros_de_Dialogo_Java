
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        
        Ventana A = new Ventana();
        
     //Fin de Programa
    }
    
    //VENTANA -------------------------------------------------------------------------------------------------------
    private static class Ventana extends JFrame {
    
        public Ventana(){
            
            this.setSize(700, 500); this.setLocationRelativeTo(null);
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            
            //PANEL DE OPCIONES
                panelOpciones opciones = new panelOpciones();

                this.add(opciones, BorderLayout.CENTER);
            
                
            //OYENTE PRICIPAL DE EVENTOS
                Eventos A = new Eventos(opciones);
            
                
            //PANEL INFERIOR
                JPanel inferior = panelInferior(A);
                
                this.add(inferior, BorderLayout.SOUTH);
            

            this.setVisible(true);
        }
        
     //Fin de Clase Ventana
    }
    
    //PANEL INFERIOR ------------------------------------------------------------------------------------------------
    private static JPanel panelInferior(Eventos A){
        
        JPanel panelInferior = new JPanel();
        
        //MUESTRA EL CUADRO DE DIALOGO
        JButton mostrar = new JButton("Mostrar");
                
            mostrar.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent ae) {
                    A.mostrar();
                }
            });
        
        //SALE DEL PROGRAMA    
        JButton salir = new JButton("Salir");

            salir.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
                    
        
        panelInferior.add(mostrar); panelInferior.add(salir);
    
        return(panelInferior);
    }
    
    //PANEL DE OPCIONES ---------------------------------------------------------------------------------------------
    private static class panelOpciones extends JPanel{

        public panelOpciones(){

            GridLayout layout = new GridLayout(2, 3);

            this.setLayout(layout);

            CuadroDialogo tipo = new CuadroDialogo();
            this.add( tipo.getTipoCuadroDialogo() );

            TipoMensaje tipoMensaje = new TipoMensaje();
            this.add( tipoMensaje.getTipoMensaje() );

            TipoConfirmar tipoConfirmar = new TipoConfirmar();
            this.add(tipoConfirmar.getTipoConfirmar());

            Mensaje mensaje = new Mensaje();
            this.add( mensaje.getMensaje() );

            Opcion opcion = new Opcion();
            this.add(opcion.getOpcion());

            EntradaModificar entrada = new EntradaModificar();
            this.add( entrada.getEntrada() );
        }

     //Fin de Clase panelOpciones  
    }
    
 //Fin de Clase Principal
}