package componentes;

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
        comboFilter.setBounds(20, 20, 400, 150);
        comboFilter.agrega("Osiel");
        comboFilter.agrega("Emanuel");
        comboFilter.agrega("Carlos");
        comboFilter.agrega("Pedro");
        add(comboFilter);
        System.out.println(comboFilter.test());
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
