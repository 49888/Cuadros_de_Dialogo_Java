
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

    public Eventos(Component componente) {
        this.componente = componente;
        
        tipoCuadro = 1; //shoMessageDialog
        tipoMensaje = -1;//PLAIN_MESSAGE
        tipoConfirmar = -1;//DEFAULT_OPTION
        mensaje = "Mensaje...";
        icono = null;
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
    
    //OYENTE TIPO DE CUADRO DE DIALOGO ---------------------------------------------------------------------------
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
                System.out.println("tipo cuadro: " + tipoCuadro);
            }
        });
    }
    
    //OENTE DE LOS TIPOS DE MENSAJES -----------------------------------------------------------------------------
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
    
    //OYENTE DE LOS TIPOS DE CONFIRMACION ------------------------------------------------------------------------
    public static void OyenteTipoConfirmar(JCheckBox A){
    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){

                switch(A.getText()){
                    
                    case "DEFAULT_OPTION":
                        tipoConfirmar = JOptionPane.DEFAULT_OPTION;
                        break;
                        
                    case "YES_NO_OPTION":
                        tipoConfirmar = JOptionPane.YES_NO_OPTION;
                        break;
                        
                    case "YES_NO_CANCEL_OPTION":
                        tipoConfirmar = JOptionPane.YES_NO_CANCEL_OPTION;
                        break;
                        
                    case "OK_CANCEL_OPTION":
                        tipoConfirmar = JOptionPane.OK_CANCEL_OPTION;
                        break;    
                }
                System.out.println("tipo confirmar: " + tipoConfirmar);
            }
        });
    }
    
    //OYENTE DE MENSAJE ------------------------------------------------------------------------------------------
    public static void OyenteMensaje(JCheckBox A, JPanel B){
        
        JTextField cuadro = new JTextField();
        
            cuadro.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mensaje = cuadro.getText();
                    cuadro.setText("Ok");
                }
            });
        
        //OYENTE DEL CheckBox
        A.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                
                if(B.getComponentCount()>1){ B.remove(1); }
                
                switch(A.getText()){
                    
                    case "Cadena":
                        
                        B.add(cuadro, BorderLayout.SOUTH);
                        
                        break;
                        
                    case "Icono":
                        
                        B.add(iconos(), BorderLayout.SOUTH);
                        
                        break;
                        
                    case "Componente":
                        
                        break;
                        
                    case "Otros":
 
                        break;
                        
                    case "Object[]":

                        break;
                }
                
                B.setVisible(false); B.setVisible(true);    
            }
        });
    }
     
    
    private static JScrollPane iconos(){
    
        JPanel panel = new JPanel();
        
        añadirIcono(panel, "corazon.png"); añadirIcono(panel, "sonrisa.png"); añadirIcono(panel, "music.png");
        añadirIcono(panel, "tren.png"); añadirIcono(panel, "java.png");
        
        //Ajustamos las Dimensiones del Panel
            Dimension size = panel.getPreferredSize();
            panel.setPreferredSize(new Dimension(size.width, size.height + 15));
        
        //Colocamos el panel dentro de un ScrollPane sin Barra lateral
            JScrollPane Scroll = new JScrollPane(panel);
            Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        return(Scroll);
    }
    
    private static void añadirIcono(JPanel A, String nombre){
        
        JButton boton = new JButton(new ImageIcon("Iconos\\16x16\\" + nombre));
        boton.setName(nombre);
        
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JButton origen = (JButton)e.getSource();
                
                mensaje = new ImageIcon("Iconos\\32x32\\" + origen.getName());
            }
        });
        
        A.add(boton);
    }
    
    //--------------------------------------------------------------------------------------------------------
    
    public static void cambiar(JButton A, Box comp){
        
        //CUADRO DE TEXTO --------------------------------------------------------------------------------------------
        JTextField cuadro = new JTextField();
        
        cuadro.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                titulo = cuadro.getText();
                cuadro.setText("Ok");
            }
        });
        
        //PANEL DE ICONCOS -------------------------------------------------------------------------------------------
        JPanel panel = new JPanel();
        
        añadirIcono2(panel, "corazon.png"); añadirIcono2(panel, "sonrisa.png"); añadirIcono2(panel, "music.png");
        añadirIcono2(panel, "tren.png"); añadirIcono2(panel, "java.png");
        
        //Ajustamos las Dimensiones del Panel
            Dimension size = panel.getPreferredSize();
            panel.setPreferredSize(new Dimension(size.width, size.height + 15));
        
        //Colocamos el panel dentro de un ScrollPane sin Barra lateral
            JScrollPane Scroll = new JScrollPane(panel);
            Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        //ACCION DEL BOTON ------------------------------------------------------------------------------------------    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JButton origen = (JButton)e.getSource();
                
                JFrame ventana = new JFrame(origen.getText());
                 
                
                if(origen.getText().equals("Cambiar Titulo")){
                    
                    ventana.setSize(300, 70);
                    ventana.add(cuadro);
                }
                else{
                    ventana.setSize(300, 90);
                    ventana.add(panel);
                }   
                ventana.setLocationRelativeTo(comp);
                ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventana.setVisible(true);
            }
        });
    }
    
    private static void añadirIcono2(JPanel A, String nombre){
        
        JButton boton = new JButton(new ImageIcon("Iconos\\16x16\\" + nombre));
        boton.setName(nombre);
        
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JButton origen = (JButton)e.getSource();
                
                icono = new ImageIcon("Iconos\\32x32\\" + origen.getName());
            }
        });
        
        A.add(boton);
    }
 //Fin de Clase Eventos  
}