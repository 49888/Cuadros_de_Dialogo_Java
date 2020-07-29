
package cuadros_de_dialogo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


public class Eventos {
    
    private Component componente;
    
    private static int tipoMensaje;
    
    private static int tipoConfirmar;
    
    private static int tipoCuadro;
    
    private static String titulo;

    public Eventos(Component componente) {
        this.componente = componente;
        
        tipoCuadro = 1; //shoMessageDialog
        tipoMensaje = -1;//PLAIN_MESSAGE
    }

    
    

    public void mostrar(){
    
        switch(tipoCuadro){
        
            //showMessageDialog
            case 1:
                
                titulo = "showMessageDialog";
                JOptionPane.showMessageDialog(componente, "mensaje", titulo, tipoMensaje, null);
                break;
                
            case 2:
                
                
                break;
                
            case 3:
                
                
                break;
                
            case 4:
                
                
                break;    
        } 
    }
    
    
    public static void OyenteTipoCuadro(JCheckBox A){
    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){

                switch(A.getName()){
                    
                    case "showMessageDialog":
                        tipoCuadro = 1;
                        break;
                        
                    case "showInputDialog":
                        tipoCuadro = 2;
                        break;
                        
                    case "showConfirmDialog":
                        tipoCuadro= 3;
                        break;
                        
                    case "showOptionDialog":
                        tipoCuadro = 4;
                        break; 
                }
                System.out.println("tipo cuadro: " + tipoMensaje);
            }
        });
    }
    
    
    public static void OyenteTipoMensaje(JCheckBox A){
    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){

                switch(A.getText()){
                    
                    case "ERROR_MESSAGE":
                        tipoMensaje = JOptionPane.ERROR_MESSAGE;
                        break;
                        
                    case "INFORMATION_MESSAGE":
                        tipoMensaje = JOptionPane.INFORMATION_MESSAGE;
                        break;
                        
                    case "WARNING_MESSAGE":
                        tipoMensaje = JOptionPane.WARNING_MESSAGE;
                        break;
                        
                    case "QUESTION_MESSAGE":
                        tipoMensaje = JOptionPane.QUESTION_MESSAGE;
                        break;
                        
                    case "PLAIN_MESSAGE":
                        tipoMensaje = JOptionPane.PLAIN_MESSAGE;
                        break; 
                }
                System.out.println("tipo mensaje: " + tipoMensaje);
            }
        });
    }
            
            
    
}
