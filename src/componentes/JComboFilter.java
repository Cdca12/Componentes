package componentes;
import java.awt.*;

import javax.swing.*;
public class JComboFilter extends JPanel{
	private JComboBox<String> combo;
	private JPanel panelBotones;
	private JButton btnOrdenadoOriginal;
	private JButton btnOrdenadoAsc;
	public JComboFilter() {
		
		initInterface();
	}
	private void initInterface() {
//		setLayout(new BorderLayout());
		//inicializar combo
		add(combo,BorderLayout.CENTER);
		panelBotones = new JPanel(new GridLayout(0, 1, 0, 2));
		btnOrdenadoOriginal = new JButton("Original");
		panelBotones.add(btnOrdenadoOriginal);
		
		btnOrdenadoAsc = new JButton("Ordenado");
		panelBotones.add(btnOrdenadoAsc);
		
		
		
		add(panelBotones, BorderLayout.EAST);
		
		
	}
}
