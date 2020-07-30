
package cuadros_de_dialogo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Eventos {
    
    //PARAMETROS
        private Component componente;

        private static Object mensaje;

        private static int tipoMensaje;

        private static int tipoConfirmar;

        private static int tipoCuadro;

        private static String titulo;
        
        private static Icon icono;

    //Constructor    
    public Eventos(Component componente){
        
        this.componente = componente;
        
        tipoCuadro = 1; //shoMessageDialog
        
        tipoMensaje = -1;//PLAIN_MESSAGE
        
        tipoConfirmar = -1;//DEFAULT_OPTION
        
        mensaje = "Mensaje...";
        
        icono = null;
        
        titulo = "Cuadro de dialogo";
    }

    //MUESTRA EL CUADRO DE DIALOGO
    public void mostrar(){
    
        switch(tipoCuadro){
        
            //showMessageDialog
            case 1:
                
                JOptionPane.showMessageDialog(componente, mensaje, titulo, tipoMensaje, icono);
                break;
           
            //showInputDialog    
            case 2:

                JOptionPane.showInputDialog(componente, mensaje, titulo, tipoMensaje, icono, null, null);
                break;
            
            //showConfirmDialog    
            case 3:

                JOptionPane.showConfirmDialog(componente, mensaje, titulo, tipoConfirmar, tipoMensaje, icono);
                break;
            
            //showOptionDialog    
            case 4:

                JOptionPane.showOptionDialog(componente, mensaje, titulo, tipoConfirmar, tipoMensaje, icono, null, null);
                break;    
        } 
    }
    
    
    //METODOS SETTER'S DE LOS PARAMETROS ---------------------------------------------------------------------------
    public static void setMensaje(Object mensaje) {
        Eventos.mensaje = mensaje;
    }

    public static void setTipoMensaje(int tipoMensaje) {
        Eventos.tipoMensaje = tipoMensaje;
    }

    public static void setTipoConfirmar(int tipoConfirmar) {
        Eventos.tipoConfirmar = tipoConfirmar;
    }

    public static void setTipoCuadro(int tipoCuadro) {
        Eventos.tipoCuadro = tipoCuadro;
    }

    public static void setTitulo(String titulo) {
        Eventos.titulo = titulo;
    }

    public static void setIcono(Icon icono) {
        Eventos.icono = icono;
    }
    
    //Fin de Clase Eventos 
}