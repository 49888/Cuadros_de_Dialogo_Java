
package cuadros_de_dialogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class panelOpciones extends JPanel{
    
    
    
    public panelOpciones(){
    
        GridLayout layout = new GridLayout(2, 3);

        this.setLayout(layout);
        
        this.add(tipo("Tipo de Cuadro de dialogo"));
        this.add(tipoMensaje("Tipo de Mensaje"));
        this.add(confirmar("Tipo de Confirmaciones"));
        
        this.add(mensaje("Tipo de Mensaje"));
        this.add(opcion("Tipo de Opciones"));
        this.add(entrada("Tipo de Entrada"));
    }
    
    
    private Box tipo(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox message = new JCheckBox("Mensaje: showMessageDialog"); 
                message.setName("showMessageDialog"); message.setSelected(true);

            JCheckBox input = new JCheckBox("Entrada: showInputDialog");
                input.setName("showInputDialog");

            JCheckBox confirm = new JCheckBox("Confirmar: showConfirmDialog");
                confirm.setName("showConfirmDialog");

            JCheckBox option = new JCheckBox("Opcion: showOptionDialog");
                option.setName("showOptionDialog");
        
        //AÑADIR OYENTES        
            Eventos.OyenteTipoCuadro(message);
            Eventos.OyenteTipoCuadro(input);
            Eventos.OyenteTipoCuadro(confirm);
            Eventos.OyenteTipoCuadro(option);
                    
        
        //Añadir Botones al grupo
        grupo.add(message); grupo.add(input); grupo.add(confirm); grupo.add(option);
        
        //Añadir Botones a la Caja
        caja.add(message); caja.add(input); caja.add(confirm); caja.add(option);
        
        //Definir el Borde de la Caja
            Border borde = BorderFactory.createLineBorder(Color.RED);
            caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    
    private Box tipoMensaje(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox error = new JCheckBox("ERROR_MESSAGE");
            JCheckBox informacion = new JCheckBox("INFORMATION_MESSAGE");
            JCheckBox alerta = new JCheckBox("WARNING_MESSAGE");
            JCheckBox pregunta = new JCheckBox("QUESTION_MESSAGE");
            JCheckBox plano = new JCheckBox("PLAIN_MESSAGE"); plano.setSelected(true);
        
        //AÑADIR OYENTES 
            Eventos.OyenteTipoMensaje(error); 
            Eventos.OyenteTipoMensaje(informacion);
            Eventos.OyenteTipoMensaje(alerta); 
            Eventos.OyenteTipoMensaje(pregunta);
            Eventos.OyenteTipoMensaje(plano);
        
        //Agregar Botones al grupo    
        grupo.add(error); grupo.add(informacion); grupo.add(alerta); grupo.add(pregunta); grupo.add(plano);
        
        //Agregar Botones a la Caja  
        caja.add(error); caja.add(informacion); caja.add(alerta); caja.add(pregunta); caja.add(plano);
        
        //Definir el Borde de la Caja
            Border borde = BorderFactory.createLineBorder(Color.RED);
            caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    
    private Box confirmar(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox defecto = new JCheckBox("DEFAULT_OPTION"); defecto.setSelected(true);
            JCheckBox siNO = new JCheckBox("YES_NO_OPTION");
            JCheckBox siNoCancelar = new JCheckBox("YES_NO_CANCEL_OPTION");
            JCheckBox okCancelar = new JCheckBox("OK_CANCEL_OPTION");

        //AÑADIR EVENTOS
            Eventos.OyenteTipoConfirmar(defecto);
            Eventos.OyenteTipoConfirmar(siNO);
            Eventos.OyenteTipoConfirmar(siNoCancelar);
            Eventos.OyenteTipoConfirmar(okCancelar);
        
        //Agregar Botones al grupo    
        grupo.add(defecto); grupo.add(siNO); grupo.add(siNoCancelar); grupo.add(okCancelar);
        
        //Agregar Botones a la Caja
        caja.add(defecto); caja.add(siNO); caja.add(siNoCancelar); caja.add(okCancelar); 
        
        //Definir el Borde de la Caja
            Border borde = BorderFactory.createLineBorder(Color.RED);
            caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    private JPanel mensaje(String titulo){
    
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
                Eventos.OyenteMensaje(cadena, panel);
                Eventos.OyenteMensaje(icono, panel);
                Eventos.OyenteMensaje(componente, panel);
                Eventos.OyenteMensaje(otros, panel);
                Eventos.OyenteMensaje(objeto, panel);

            grupo.add(cadena); grupo.add(icono); grupo.add(componente); grupo.add(otros); grupo.add(objeto);

            caja.add(cadena); caja.add(icono); caja.add(componente); caja.add(otros); caja.add(objeto);

        panel.add(caja, BorderLayout.CENTER);
        
   
        
        //DEFINIMOS EL BORDE DEL PANEL
        Border borde = BorderFactory.createLineBorder(Color.RED);
        panel.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(panel);
    }
    
    private Box opcion(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox cadenas = new JCheckBox("String[]");
        JCheckBox iconos = new JCheckBox("Icon[]");
        JCheckBox objetos = new JCheckBox("Object[]");

        
        grupo.add(cadenas); grupo.add(iconos); grupo.add(objetos); 
        
        caja.add(cadenas); caja.add(iconos); caja.add(objetos);
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    private JPanel entrada(String titulo){
    
        JPanel panel = new JPanel(new GridLayout(2, 1));
        
        Box caja1 = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
            ButtonGroup grupo = new ButtonGroup();

            JCheckBox texto = new JCheckBox("Cuadro de texto");
            JCheckBox combo = new JCheckBox("Menu desplegable");

            grupo.add(texto); grupo.add(combo); 

            caja1.add(texto); caja1.add(combo); 
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja1.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        panel.add(caja1);
        
        Box caja2 = new Box(BoxLayout.Y_AXIS);
        
            JButton cambiarTitulo = new JButton("Cambiar Titulo");
            JButton cambiarIcono = new JButton("Cambiar Icono");
            
            Eventos.cambiar(cambiarTitulo, caja2); Eventos.cambiar(cambiarIcono, caja2);
        
        caja2.add(cambiarTitulo); caja2.add(Box.createVerticalStrut(10)); caja2.add(cambiarIcono); 
        
        caja2.setBorder(BorderFactory.createTitledBorder(borde, "Modificar"));
        
        panel.add(caja2);
        
        return(panel);
    }
 //Fin de Clase panelOpciones  
}