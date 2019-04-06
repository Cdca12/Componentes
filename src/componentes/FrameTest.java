package componentes;

import java.awt.Color;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author Carlos Contreras
 * @author Osiel Sainz
 */
public class FrameTest extends JFrame {

    JComboFilter comboFilter;

    public FrameTest() {

        comboFilter = new JComboFilter();
        comboFilter.setBounds(20, 20, 200, 50);
        comboFilter.agrega("Osiel");
        comboFilter.agrega("Emanuel");
        comboFilter.agrega("Carlos");
        comboFilter.agrega("Daniel");
        comboFilter.agrega("Oscar");
        comboFilter.agrega("Paul");
        comboFilter.agrega("Paul");
        comboFilter.agrega("Paul");
        comboFilter.agrega("Paul");
        comboFilter.agrega("Paul");
        comboFilter.setBorder(BorderFactory.createLineBorder(Color.RED));

        JComboFilter nuevoComboFilter = new JComboFilter();
        nuevoComboFilter.setBounds(20, 130, 200, 50);
        Vector<String> vectorDatos = new Vector<String>();
        vectorDatos.add("Osiel");
        vectorDatos.add("Carlos");
        vectorDatos.add("Osiel");
        vectorDatos.add("Mario");
        vectorDatos.add("Omar");
        vectorDatos.add("Michel");
        vectorDatos.add("Pero");
        nuevoComboFilter.agrega(vectorDatos);
        nuevoComboFilter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(nuevoComboFilter);

        add(comboFilter);
        setLayout(null);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameTest();
    }

}
