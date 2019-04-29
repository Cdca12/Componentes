package componentes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AppTest extends JFrame implements ActionListener{
	JCajasMultiples cajaMultiple;
	JPanel pnlMenu;
	JTextField txtPos;
	JButton btnImprimir;
	JButton btnImprimirTodo;
	public AppTest() {
		super("Test");
		initInterface();
	}
	public void initInterface() {
		setSize(500, 400);
//		setResizable(false);
//		setLayout(null);
		
		añadeJCajaTexto();
		añadirMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void añadeJCajaTexto() {
		cajaMultiple = new JCajasMultiples();
		cajaMultiple.getComponent().setBounds(30, 30, 400, 300);
		add(cajaMultiple.getComponent(), BorderLayout.CENTER);
	}
	private void añadirMenu() {
		pnlMenu = new JPanel(new GridLayout(0, 3, 1, 1));
		btnImprimirTodo = new JButton("Imprimir Datos");
		btnImprimirTodo.addActionListener(this);
		pnlMenu.add(btnImprimirTodo);
		
		txtPos = new JTextField();
		pnlMenu.add(txtPos);
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		pnlMenu.add(btnImprimir);
		
		add(pnlMenu,BorderLayout.SOUTH);
	}
	private void imprimirDatos() {
		String datos[];
		datos = cajaMultiple.getInfo();
		for(int i=0;i<datos.length;i++)
			System.out.println(datos[i]);

	}
	private void imprimirDato(int pos) {
		System.out.println(cajaMultiple.getInfo(pos));

	}
	public static void main(String[] args) {
		new AppTest();
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == btnImprimirTodo) {
			imprimirDatos();
			System.out.println("-------------------------------------");
//			return;
		}
		if(evt.getSource() == btnImprimir) {
			int pos = Integer.parseInt(txtPos.getText());
			imprimirDato(pos);
			System.out.println("-------------------------------------");
			return;
		}
			
			
		
	}
}
