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
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);

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
        		"Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", 
        		"Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", 
        		"Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas", "Ciudad de México"};
        otroComboFilter.agrega(datos);
        otroComboFilter.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        add(otroComboFilter);

        //Cajas Multiples
        JCajasMultiples cajas = new JCajasMultiples();
        cajas.getComponent().setBounds(300, 50, 500, 300);
        add(cajas.getComponent());
        
        
        JCombosDependientes combosDependientes = new JCombosDependientes();
        combosDependientes.setBounds(10, 400, 600, 40);
        combosDependientes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(combosDependientes);


        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameTest();
    }

}
