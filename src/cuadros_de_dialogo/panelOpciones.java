
package cuadros_de_dialogo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
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
            
            Eventos.OyenteTipoCuadro(message); Eventos.OyenteTipoCuadro(input);
            Eventos.OyenteTipoCuadro(confirm); Eventos.OyenteTipoCuadro(option);
                    
        
        
        grupo.add(message); grupo.add(input); grupo.add(confirm); grupo.add(option);
        
        caja.add(message); caja.add(input); caja.add(confirm); caja.add(option);
        
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
        JCheckBox plano = new JCheckBox("PLAIN_MESSAGE");
            plano.setSelected(true);
        
        Eventos.OyenteTipoMensaje(error); Eventos.OyenteTipoMensaje(informacion);
        Eventos.OyenteTipoMensaje(alerta); Eventos.OyenteTipoMensaje(pregunta);
        Eventos.OyenteTipoMensaje(plano);
        
        grupo.add(error); grupo.add(informacion); grupo.add(alerta); grupo.add(pregunta); grupo.add(plano);
        
        caja.add(error); caja.add(informacion); caja.add(alerta); caja.add(pregunta); caja.add(plano);
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    private Box confirmar(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox defecto = new JCheckBox("DEFAULT_OPTION");
        JCheckBox siNO = new JCheckBox("YES_NO_OPTION");
        JCheckBox siNoCancelar = new JCheckBox("YES_NO_CANCEL_OPTION");
        JCheckBox okCancelar = new JCheckBox("OK_CANCEL_OPTION");

        
        grupo.add(defecto); grupo.add(siNO); grupo.add(siNoCancelar); grupo.add(okCancelar);
        
        caja.add(defecto); caja.add(siNO); caja.add(siNoCancelar); caja.add(okCancelar); 
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    private Box mensaje(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox cadena = new JCheckBox("Cadena");
        JCheckBox icono = new JCheckBox("Icono");
        JCheckBox componente = new JCheckBox("Componente");
        JCheckBox otros = new JCheckBox("Otros");
        JCheckBox objeto = new JCheckBox("Object[]");

        
        grupo.add(cadena); grupo.add(icono); grupo.add(componente); grupo.add(otros); grupo.add(objeto);
        
        caja.add(cadena); caja.add(icono); caja.add(componente); caja.add(otros); caja.add(objeto);
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    private Box opcion(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox cadenas = new JCheckBox("DEFAUTL_OPTION");
        JCheckBox iconos = new JCheckBox("YES_NO_OPTION");
        JCheckBox objetos = new JCheckBox("YES_NO_CANCEL_OPTION");

        
        grupo.add(cadenas); grupo.add(iconos); grupo.add(objetos); 
        
        caja.add(cadenas); caja.add(iconos); caja.add(objetos);
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
    
    private Box entrada(String titulo){
    
        Box caja = new Box(BoxLayout.Y_AXIS);
        
        //Componentes
        ButtonGroup grupo = new ButtonGroup();
        
        JCheckBox texto = new JCheckBox("DEFAUTL_OPTION");
        JCheckBox combo = new JCheckBox("YES_NO_OPTION");


        
        grupo.add(texto); grupo.add(combo); 
        
        caja.add(texto); caja.add(combo); 
        
        Border borde = BorderFactory.createLineBorder(Color.RED);
        caja.setBorder(BorderFactory.createTitledBorder(borde, titulo));
        
        return(caja);
    }
 //Fin de Clase panelOpciones  
}
