
package cuadros_de_dialogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Mensaje {
    
    //PANEL DE MENSAJE ---------------------------------------------------------------------------------------------
    public JPanel getMensaje(){
    
        JPanel panel = new JPanel(new BorderLayout());
        
        //CAJA -----------------------------------------------------------------
            Box caja = new Box(BoxLayout.Y_AXIS);

            //Componentes
                ButtonGroup grupo = new ButtonGroup();

                JCheckBox cadena = new JCheckBox("Cadena"); //cadena.setSelected(true);
                JCheckBox icono = new JCheckBox("Icono");
                JCheckBox componente = new JCheckBox("Componente");
                JCheckBox otros = new JCheckBox("Otros");
                JCheckBox objeto = new JCheckBox("Object[]");
                
            //AÑADIR OYENTES
                OyenteMensaje(cadena, panel);
                OyenteMensaje(icono, panel);
                OyenteMensaje(componente, panel);
                OyenteMensaje(otros, panel);
                OyenteMensaje(objeto, panel);

            grupo.add(cadena); grupo.add(icono); grupo.add(componente); grupo.add(otros); grupo.add(objeto);

            caja.add(cadena); caja.add(icono); caja.add(componente); caja.add(otros); caja.add(objeto);

        panel.add(caja, BorderLayout.CENTER);
        
   
        
        //DEFINIMOS EL BORDE DEL PANEL
            Border borde = BorderFactory.createLineBorder(Color.RED);
            panel.setBorder(BorderFactory.createTitledBorder(borde, "Mensaje"));
        
        return(panel);
    }

    
    //OYENTE DE MENSAJE ------------------------------------------------------------------------------------------
    public void OyenteMensaje(JCheckBox A, JPanel B){

        //OYENTE DEL CheckBox
        A.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                
                if(B.getComponentCount()>1){ 
                    
                    B.remove(1); 
                }
                
                switch(A.getText()){
                    
                    case "Cadena":
                        
                        B.add(cadenas(), BorderLayout.SOUTH);
                        
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
    
    //1º Opcion: Cadenas - Establece un Mensaje tipo Cadena ------------------------------------------------------
    private JTextField cadenas(){
    
        JTextField cuadro = new JTextField();
        
        cuadro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                Eventos.setMensaje(cuadro.getText());
                cuadro.setText("Ok");
            }
        });
    
        return(cuadro);
    }
    
    //2º Opcion: Iconos - Establece un Mensaje tipo Icono --------------------------------------------------------
    private JScrollPane iconos(){
    
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
    
    //Permite agregar mas Iconos a 2º Opcion con facilidad
    private void añadirIcono(JPanel A, String nombre){
        
        JButton boton = new JButton(new ImageIcon("Iconos\\16x16\\" + nombre));
        boton.setName(nombre);
        
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JButton origen = (JButton)e.getSource();
                
                Eventos.setMensaje(new ImageIcon("Iconos\\32x32\\" + origen.getName()));
            }
        });
        
        A.add(boton);
    }
    
    
 //Fin de Clase Mensaje  
}
