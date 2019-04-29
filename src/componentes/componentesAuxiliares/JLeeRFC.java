package componentes.componentesAuxiliares;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JLeeRFC extends JTextField implements FocusListener,KeyListener{
	private boolean textoValido;
	private Border colorDefault;
	private Color textoColorDefault;
	private final String HINT = "R F C";
	public JLeeRFC() {
		addFocusListener(this);
		addKeyListener(this);
		
		colorDefault = getBorder();
		textoColorDefault = getForeground();
		
		setText(HINT);
		setForeground(new Color(142, 142, 142));
	}
	private boolean valida() {
		return getText().matches("^[A-Z]{4}[0-9]{6}[A-Z|0-9]{3}$");
	}
	public String getTextValidado() {
		if(textoValido)
			return getText();
		return null;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		setForeground(textoColorDefault);
		if(getText().equals(HINT))
			setText(null);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		String min = getText();
		setText(min.toUpperCase());
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(getText().length()==0) {
			setText(HINT);
			setForeground(new Color(142, 142, 142));
		}
		if(valida()) {
			
			setBorder(BorderFactory.createLineBorder(new Color(46, 219, 0)));
			textoValido = true;
			return;
		}
		if(getText().equals(HINT)){
			setBorder(colorDefault);
			return;
		}
		setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		textoValido = false;
	}
	
	
}
