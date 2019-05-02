package componentes.componentesAuxiliares;

import java.awt.*;

import javax.swing.*;

public class JPanelCaja extends JPanel {

    private JLee textField;
    private JButton btnEliminar;
    private int tipo;

    public JPanelCaja(int tipo) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        creaCaja(tipo);
        this.tipo = tipo;
    }

    private void creaCaja(int tipo) {
        btnEliminar = new JButton();
        btnEliminar.setIcon(AjustarImagen("./src/componentes/Files/delete-icon.png", 25, 25));
        btnEliminar.setPreferredSize(new Dimension(25,25));
        btnEliminar.setContentAreaFilled(false);     
        btnEliminar.setBorderPainted(false); // Elimina el recuadro que rodea al boton
        switch (tipo) {
            case 0://Correo
            	textField = new JLee(1);
            	textField.setPreferredSize(new Dimension(300, 35));
                add(textField);
                add(btnEliminar);
                break;
            case 1://RFC
            	textField = new JLee(2);
            	textField.setPreferredSize(new Dimension(300, 35));
                add(textField);
                add(btnEliminar);
                break;
            case 2://NumTel
            	textField = new JLee(3);
            	textField.setPreferredSize(new Dimension(300, 35));
                add(textField);
                add(btnEliminar);
                break;
        }
    }

    public String getInfo() {
    	return textField.getTextValidado();
    }
    
    public String getText() {
        return textField.getText();
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    private static ImageIcon AjustarImagen(String ico, int Ancho, int Alto) {
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
                Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
        return tmpIcon;
    }
}
