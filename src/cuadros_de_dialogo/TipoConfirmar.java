
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TipoConfirmar {
    
    public Box getTipoConfirmar(){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox defecto = new JCheckBox("DEFAULT_OPTION"); defecto.setSelected(true);
            JCheckBox siNO = new JCheckBox("YES_NO_OPTION");
            JCheckBox siNoCancelar = new JCheckBox("YES_NO_CANCEL_OPTION");
            JCheckBox okCancelar = new JCheckBox("OK_CANCEL_OPTION");

        //AÑADIR EVENTOS
            OyenteTipoConfirmar(defecto);
            OyenteTipoConfirmar(siNO);
            OyenteTipoConfirmar(siNoCancelar);
            OyenteTipoConfirmar(okCancelar);
        
        //Agregar Botones al grupo    
        grupo.add(defecto); grupo.add(siNO); grupo.add(siNoCancelar); grupo.add(okCancelar);
        
        //Agregar Botones a la Caja
        caja.add(defecto); caja.add(siNO); caja.add(siNoCancelar); caja.add(okCancelar); 
        
        //Definir el Borde de la Caja
            Border borde = BorderFactory.createLineBorder(Color.RED);
            caja.setBorder(BorderFactory.createTitledBorder(borde, "Tipo de Confirmacion"));
        
        return(caja);
    }
    
    //OYENTE DE LOS TIPOS DE CONFIRMACION ------------------------------------------------------------------------
    public static void OyenteTipoConfirmar(JCheckBox A){
    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){

                switch(A.getText()){
                    
                    case "DEFAULT_OPTION":
                        
                        Eventos.setTipoConfirmar(JOptionPane.DEFAULT_OPTION);
                        break;
                        
                    case "YES_NO_OPTION":
                        
                        Eventos.setTipoConfirmar(JOptionPane.YES_NO_OPTION);
                        break;
                        
                    case "YES_NO_CANCEL_OPTION":
                        
                        Eventos.setTipoConfirmar(JOptionPane.YES_NO_CANCEL_OPTION);
                        break;
                        
                    case "OK_CANCEL_OPTION":
                        
                        Eventos.setTipoConfirmar(JOptionPane.OK_CANCEL_OPTION);
                        break;    
                }
            }
        });
    }
  
 //Fin de Clase TipoConfirmar
}
