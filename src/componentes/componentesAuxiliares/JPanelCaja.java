package componentes.componentesAuxiliares;

import java.awt.*;

import javax.swing.*;

public class JPanelCaja extends JPanel {

    private JLeeCorreo correo;
    private JLeeRFC rfc;
    private JLeeNumeroTel numTel;
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
                correo = new JLeeCorreo();
                correo.setPreferredSize(new Dimension(300, 35));
                add(correo);
                add(btnEliminar);
                break;
            case 1://RFC
                rfc = new JLeeRFC();
                rfc.setPreferredSize(new Dimension(300, 35));
                add(rfc);
                add(btnEliminar);
                break;
            case 2://NumTel
                numTel = new JLeeNumeroTel();
                numTel.setPreferredSize(new Dimension(300, 35));
                add(numTel);
                add(btnEliminar);
                break;
        }
    }

    public String getInfo() {
        if (tipo == 0) {
            return correo.getTextValidado();
        }
        if (tipo == 1) {
            return rfc.getTextValidado();
        }
        if (tipo == 2) {
            return "" + numTel.getTextValidado();
        }
        return "";
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public static ImageIcon AjustarImagen(String ico, int Ancho, int Alto) {
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
                Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
        return tmpIcon;
    }
}
