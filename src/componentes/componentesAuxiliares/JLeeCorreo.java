package componentes.componentesAuxiliares;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JLeeCorreo extends JTextField implements FocusListener,KeyListener{
	private boolean textoValido;
	private Border colorDefault;
	private Color textoColorDefault;
	public JLeeCorreo() {
		addFocusListener(this);
		addKeyListener(this);
		
		colorDefault = getBorder();
		textoColorDefault = getForeground();
		
		setText("example@dir.com");
		setForeground(new Color(142, 142, 142));		
	}
	
	private boolean valida() {
		return getText().matches("^[a-z][a-z|0-9|_|.|-]{1,15}@[a-z]{2,8}\\.[a-z]{2,3}$");
	}
	public String getTextValidado() {
		if(textoValido)
			return getText();
		return null;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if(getText().length()==0) {
			setText("example@dir.com");
			setForeground(new Color(142, 142, 142));
		}
		if(valida()) {
			if(getText().equals("example@dir.com")){
				setBorder(colorDefault);
				return;
			}
			setBorder(BorderFactory.createLineBorder(new Color(46, 219, 0)));
			textoValido = true;
			return;
		}
		setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		textoValido = false;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		setForeground(textoColorDefault);
		if(getText().equals("example@dir.com"))
			setText(null);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
}
