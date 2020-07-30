
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class CuadroDialogo {
    
    public Box getTipoCuadroDialogo(){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox message = new JCheckBox("Mensaje: showMessageDialog"); 
                message.setName("showMessageDialog");
                message.setSelected(true);

            JCheckBox input = new JCheckBox("Entrada: showInputDialog");
                input.setName("showInputDialog");

            JCheckBox confirm = new JCheckBox("Confirmar: showConfirmDialog");
                confirm.setName("showConfirmDialog");

            JCheckBox option = new JCheckBox("Opcion: showOptionDialog");
                option.setName("showOptionDialog");
        
        //AÑADIR OYENTES        
            OyenteTipoCuadro(message);
            OyenteTipoCuadro(input);
            OyenteTipoCuadro(confirm);
            OyenteTipoCuadro(option);
                    
        
        //Añadir Botones al grupo
        grupo.add(message); grupo.add(input); grupo.add(confirm); grupo.add(option);
        
        //Añadir Botones a la Caja
        caja.add(message); caja.add(input); caja.add(confirm); caja.add(option);
        
        //Definir el Borde de la Caja
            Border borde = BorderFactory.createLineBorder(Color.RED);
            caja.setBorder(BorderFactory.createTitledBorder(borde, "Tipo de Cuadro de Dialogo"));
        
        return(caja);
    }
    
    //OYENTE TIPO DE CUADRO DE DIALOGO ---------------------------------------------------------------------------
    public static void OyenteTipoCuadro(JCheckBox A){
    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){

                switch(A.getName()){
                    
                    case "showMessageDialog":
                        
                        Eventos.setTipoCuadro(1);
                        break;
                        
                    case "showInputDialog":
                        
                        Eventos.setTipoCuadro(2);
                        break;
                        
                    case "showConfirmDialog":
                        
                        Eventos.setTipoCuadro(3);
                        break;
                        
                    case "showOptionDialog":
                        
                        Eventos.setTipoCuadro(4);
                        break; 
                }
                
            }
        });
    }
    
    
 //Fin de Clase CuadroDialogo   
}
