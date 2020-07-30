
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TipoMensaje {
    
    public Box getTipoMensaje(){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox error = new JCheckBox("ERROR_MESSAGE");
            
            JCheckBox informacion = new JCheckBox("INFORMATION_MESSAGE");
            
            JCheckBox alerta = new JCheckBox("WARNING_MESSAGE");
            
            JCheckBox pregunta = new JCheckBox("QUESTION_MESSAGE");
            
            JCheckBox plano = new JCheckBox("PLAIN_MESSAGE"); 
                plano.setSelected(true);
        
        //AÑADIR OYENTES 
            OyenteTipoMensaje(error); 
            OyenteTipoMensaje(informacion);
            OyenteTipoMensaje(alerta); 
            OyenteTipoMensaje(pregunta);
            OyenteTipoMensaje(plano);
        
        //Agregar Botones al grupo    
        grupo.add(error); grupo.add(informacion); grupo.add(alerta); grupo.add(pregunta); grupo.add(plano);
        
        //Agregar Botones a la Caja  
        caja.add(error); caja.add(informacion); caja.add(alerta); caja.add(pregunta); caja.add(plano);
        
        //Definir el Borde de la Caja
            Border borde = BorderFactory.createLineBorder(Color.RED);
            caja.setBorder(BorderFactory.createTitledBorder(borde, "Tipo de Mensaje"));
        
        return(caja);
    }
    
    //OENTE DE LOS TIPOS DE MENSAJES -----------------------------------------------------------------------------
    private void OyenteTipoMensaje(JCheckBox A){
    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){

                switch(A.getText()){
                    
                    case "ERROR_MESSAGE":
                        
                        Eventos.setTipoMensaje(JOptionPane.ERROR_MESSAGE);
                        break;
                        
                    case "INFORMATION_MESSAGE":
                        
                        Eventos.setTipoMensaje(JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                    case "WARNING_MESSAGE":
                        
                        Eventos.setTipoMensaje(JOptionPane.WARNING_MESSAGE);
                        break;
                        
                    case "QUESTION_MESSAGE":
                        
                        Eventos.setTipoMensaje(JOptionPane.QUESTION_MESSAGE);
                        break;
                        
                    case "PLAIN_MESSAGE":
                        
                        Eventos.setTipoMensaje(JOptionPane.PLAIN_MESSAGE);
                        break; 
                }
            }
        });
    }
 
 //Fin de la Clase TipoMensaje
}
