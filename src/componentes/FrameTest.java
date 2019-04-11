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
        setLayout(null);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);

        // CombosFiltrados
        comboFilter = new JComboFilter();
        comboFilter.setBounds(20, 20, 230, 50);
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
        add(comboFilter);

        JComboFilter nuevoComboFilter = new JComboFilter();
        nuevoComboFilter.setBounds(20, 130, 230, 50);
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

        JComboFilter otroComboFilter = new JComboFilter();
        otroComboFilter.setBounds(20, 250, 230, 50);
        String[] datos = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua",
            "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico", "Michoacan",
            "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo", "San Luis Potosi",
            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas", "Ciudad de Mexico"};
        otroComboFilter.agrega(datos);
        otroComboFilter.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        add(otroComboFilter);

        //Cajas Multiples
        JCajasMultiples cajas = new JCajasMultiples();
        cajas.getComponent().setBounds(300, 50, 500, 300);
        add(cajas.getComponent());

        // CombosDependientes
        JCombosDependientes combosDependientesA = new JCombosDependientes();
        combosDependientesA.setBounds(10, 400, 600, 40);
        combosDependientesA.setBorder(BorderFactory.createLineBorder(Color.RED));
        add(combosDependientesA);

        JCombosDependientes combosDependientesB = new JCombosDependientes("BC");
        combosDependientesB.setBounds(10, 460, 600, 40);
        combosDependientesB.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(combosDependientesB);

        JCombosDependientes combosDependientesC = new JCombosDependientes("BC", "Tijuana");
        combosDependientesC.setBounds(10, 520, 600, 40);
        combosDependientesC.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        add(combosDependientesC);

        JCombosDependientes combosDependientesD = new JCombosDependientes("BC", "Tijuana", "Tij1");
        combosDependientesD.setBounds(10, 580, 600, 40);
        combosDependientesD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(combosDependientesD);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameTest();
    }

}
