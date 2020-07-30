
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class EntradaModificar {
   
    public JPanel getEntrada(){
    
        JPanel panel = new JPanel(new GridLayout(2, 1));
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        
        //CAJA 1 - Opciones de Entrada ----------------------------------------------------------------------------
            Box caja1 = new Box(BoxLayout.Y_AXIS);

            //Componentes
                ButtonGroup grupo = new ButtonGroup();

                JCheckBox texto = new JCheckBox("Cuadro de texto");
                JCheckBox combo = new JCheckBox("Menu desplegable");

                //Añadimos los Compontentes al grupo de Botones
                grupo.add(texto); grupo.add(combo);
                
                //Añadimos los Componentes a la Caja
                caja1.add(texto); caja1.add(combo); 

            //Establecemos el Borde de la Caja
            caja1.setBorder(BorderFactory.createTitledBorder(borde, "Entrada"));
        
        panel.add(caja1);
        
        
        //CAJA 2 - Opciones de Modificar --------------------------------------------------------------------------
            Box caja2 = new Box(BoxLayout.Y_AXIS);

            //Componenentes
                JButton cambiarTitulo = new JButton("Cambiar Titulo");
                JButton cambiarIcono = new JButton("Cambiar Icono");

            //Añadir Oyentes    
                cambiar(cambiarTitulo, caja2); cambiar(cambiarIcono, caja2);

            //Añadimos los Componentes a la Caja    
            caja2.add(cambiarTitulo); caja2.add(Box.createVerticalStrut(10)); caja2.add(cambiarIcono); 
            
            //Establecemos el Borde de la Caja
            caja2.setBorder(BorderFactory.createTitledBorder(borde, "Modificar"));
        
        panel.add(caja2);
        
        return(panel);
    }
    
    //MODIFICAR - Cambia el Titulo o el Icono principal
    private void cambiar(JButton A, Box comp){
        
        
        
        
        
        //ACCION DEL BOTON ------------------------------------------------------------------------------------------    
        A.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JButton origen = (JButton)e.getSource();
                
                JFrame ventana = new JFrame(origen.getText());
                 
                if(origen.getText().equals("Cambiar Titulo")){
                    
                    ventana.setSize(300, 70);
                    ventana.add(Titulo());
                }
                else{
                    
                    ventana.setSize(300, 90);
                    ventana.add(Icono());
                }   
                
                ventana.setLocationRelativeTo(comp);
                
                ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                ventana.setVisible(true);
            }
        });
    }
    
    private JTextField Titulo(){
    
        JTextField cuadro = new JTextField();
        
        cuadro.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                Eventos.setTitulo(cuadro.getText());
                cuadro.setText("Ok");
            }
        });
        
        return(cuadro);
    }
    
    private JPanel Icono(){
        
        //PANEL DE ICONCOS -------------------------------------------------------------------------------------------
        JPanel panel = new JPanel();
        
        //Añadimos los Botones con Iconos
            añadirIcono(panel, "corazon.png");
            añadirIcono(panel, "sonrisa.png");
            añadirIcono(panel, "music.png");
            añadirIcono(panel, "tren.png");
            añadirIcono(panel, "java.png");
        
        //Ajustamos las Dimensiones del Panel
            Dimension size = panel.getPreferredSize();
            
            panel.setPreferredSize(new Dimension(size.width, size.height + 15));
        
        //Colocamos el panel dentro de un ScrollPane sin Barra lateral
            JScrollPane Scroll = new JScrollPane(panel);
            
            Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    
        return(panel);
    }
    
    private void añadirIcono(JPanel A, String nombre){
        
        JButton boton = new JButton(new ImageIcon("Iconos\\16x16\\" + nombre));
        
        boton.setName(nombre);
        
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JButton origen = (JButton)e.getSource();
                
                Eventos.setIcono(new ImageIcon("Iconos\\32x32\\" + origen.getName()));
            }
        });
        
        A.add(boton);
    }
    
 //Fin de la Clase EntradaModificar
}
