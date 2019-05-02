package componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Carlos Contreras
 * @author Osiel Sainz
 */
public class FrameTest extends JFrame {
    
    static JCajasMultiples cajasMultiples;

    public FrameTest() {
        setLayout(null);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        
        // Primer componente: CombosFiltrados
        // Test 1: Vacío y añadiendo uno por uno
        JComboFilter comboFilter = new JComboFilter();
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
        System.out.println("---------------------------------------\n\t  Test JComboFilter\n---------------------------------------");
        System.out.println("Individualmente:");
        System.out.println("PrimerComboFilter: " + comboFilter.getText()
                + "\nSegundo ComboFilter: " + nuevoComboFilter.getText()
                + "\nTercer ComboFilter: " + otroComboFilter.getText());
        // Todos los datos
        System.out.println("\nObteniendo datos como arreglo:");
        String[] datosPrimerComponente = otroComboFilter.getDatos();
        for (int i = 0; i < datosPrimerComponente.length; System.out.println(datosPrimerComponente[i]), i++);    
        
        
        // JCajasMultiples
        // Nota: Se usa getComponent ya que, al estar hecho con MVC, estamos creando la clase que instancia el modelo, vista y controlador.
        
        // Test 1: Sin parámetros
        cajasMultiples = new JCajasMultiples();
        cajasMultiples.getComponent().setBounds(300, 50, 380, 300);
        add(cajasMultiples.getComponent());
        
        // Test 2: Número de cajas máximo como parámetros
        JCajasMultiples otroCajasMultiples = new JCajasMultiples(5);
        otroCajasMultiples.getComponent().setBounds(700, 50, 380, 300);
        add(otroCajasMultiples.getComponent());

        // Test 3: Obtener información. Ver consola.

        
        // CombosDependientes 
        // Test 1: Normal
        JCombosDependientes combosDependientesA = new JCombosDependientes();
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
        
        // Test 5: Añadir componente en Vertical
        JCombosDependientes otrocombosDependientesA = new JCombosDependientes();
        otrocombosDependientesA.setBounds(630, 400, 200, 100); 
        add(otrocombosDependientesA);
        
        JCombosDependientes otrocombosDependientesB = new JCombosDependientes("Baja California");
        otrocombosDependientesB.setBounds(850, 400, 200, 100); 
        add(otrocombosDependientesB);
        
        JCombosDependientes otrocombosDependientesC = new JCombosDependientes("Sinaloa", "Culiacan");
        otrocombosDependientesC.setBounds(630, 530, 200, 100); 
        add(otrocombosDependientesC);
        
        JCombosDependientes otrocombosDependientesD = new JCombosDependientes("Nuevo Leon", "Monterrey", "CdMon1");
        otrocombosDependientesD.setBounds(850, 530, 200, 100); 
        add(otrocombosDependientesD);

        // Test 5: Obtener información
        System.out.println("---------------------------------------\n\t  Test JCombosDependientes\n---------------------------------------");
        System.out.println("Individualmente:");
        System.out.println("Estado = " + combosDependientesD.getEstado() + ""
                + "\nMunicipio = " + combosDependientesD.getMunicipio()
                + "\nCiudad = " + combosDependientesD.getCiudad());
        System.out.println("\nComo arreglo:");
        String[] datosArreglo = combosDependientesD.getDatos();
        for (int i = 0; i < datosArreglo.length; System.out.println(datosArreglo[i]), i++);
        
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameTest();
        // Test: Obtener información JCajasMultiples
        System.out.println("---------------------------------------\n\t  Test JCajasMultiples\n---------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int numero = -2;
        while (numero != -1) {
            System.out.println("Ingrese la posicion para probar: (99 para obtener todo)");
            numero = scanner.nextInt();
            if (numero == 99) {
                String[] arregloDatos = cajasMultiples.getText();
                for (int i = 0; i < arregloDatos.length; i++) {
                    System.out.println("Dato " + (i+1) + ": " + arregloDatos[i]);
                }
                continue;
            }
            System.out.println("Dato en posición " + numero + ": " + cajasMultiples.getText(numero));
        }
    }

}
