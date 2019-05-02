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
        setResizable(false);

        // Primer componente: CombosFiltrados
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
        add(comboFilter);

        // Test 2: Añadiendo un Vector
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
        add(nuevoComboFilter);

        // Test 3: Añadiendo un arreglo String primitivo
        JComboFilter otroComboFilter = new JComboFilter();
        otroComboFilter.setBounds(20, 250, 230, 50);
        String[] datos = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua",
            "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico", "Michoacan",
            "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo", "San Luis Potosi",
            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas", "Ciudad de Mexico"};
        otroComboFilter.agrega(datos);
        add(otroComboFilter);
        
        // Test 4: Obtener información
        System.out.println("Primer Combo Filter: " + comboFilter.getText()
                + "\nSegundo Combo Filter: " + nuevoComboFilter.getText()
                + "\nTercer Combo Filter: " + otroComboFilter.getText());

        //Segundo componente: Cajas Multiples
        JCajasMultiples cajas = new JCajasMultiples();
        cajas.getComponent().setBounds(300, 50, 380, 300);
        add(cajas.getComponent());

        // Primer componente: CombosDependientes
        JCombosDependientes combosDependientesA = new JCombosDependientes();
//        combosDependientesA.setBounds(10, 400, 200, 200); // Test: Añadir componente en Vertical
        combosDependientesA.setBounds(10, 400, 600, 40);
        add(combosDependientesA);

        // Test 2: Constructor con Estado
        JCombosDependientes combosDependientesB = new JCombosDependientes("Aguascalientes");
        combosDependientesB.setBounds(10, 460, 600, 40);
        add(combosDependientesB);

        // Test 3: Constructor con Estado, Municipio
        JCombosDependientes combosDependientesC = new JCombosDependientes("Aguascalientes", "cosio");
        combosDependientesC.setBounds(10, 520, 600, 40);
        add(combosDependientesC);

        // Test 4: Constructor con Estado, Municipio, Ciudad
        JCombosDependientes combosDependientesD = new JCombosDependientes("Aguascalientes", "cosio", "CdCos3");
        combosDependientesD.setBounds(10, 580, 600, 40);
        add(combosDependientesD);

        // Test 5: Obtener información
        System.out.println("Estado = " + combosDependientesD.getEstado() + ""
                + "\nMunicipio = " + combosDependientesD.getMunicipio()
                + "\nCiudad = " + combosDependientesD.getCiudad());
        String[] datosArreglo = combosDependientesD.getDatos();
        for (int i = 0; i < datosArreglo.length; System.out.println(datosArreglo[i]), i++);
        
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameTest();
    }

}
