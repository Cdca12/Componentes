package componentes.componentesAuxiliares;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JLeeNumeroTel extends JTextField implements FocusListener, KeyListener{
	private boolean textoValido;
	private Border colorDefault;
	private Color textoColorDefault;
	private final String HIDDEN = "(123)123-1234";
	public JLeeNumeroTel() {
		addFocusListener(this);
		addKeyListener(this);
		
		colorDefault = getBorder();
		textoColorDefault = getForeground();
		
		setText(HIDDEN);
		setForeground(new Color(142, 142, 142));
	}
	
	private boolean valida() {
		return getText().matches("^\\([0-9]{3}\\)[0-9]{3}\\-[0-9]{4}$");
	}
	public Integer getTextValidado() {
		if(textoValido)
			return quitaFormato();
		return null;
	}
	public int quitaFormato() {
		String numeroInt="";
		String numeroString = getText();
		for(int i=0;i<numeroString.length();i++) 
			if(!(numeroInt.charAt(i)=='(' || numeroInt.charAt(i)==')' || numeroInt.charAt(i)=='-'))
				numeroInt += numeroInt.charAt(i);
		
		return Integer.parseInt(numeroInt);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(getText().length()==0) {
			setText(HIDDEN);
			setForeground(new Color(142, 142, 142));
		}
		if(valida()) {
			if(getText().equals(HIDDEN)){
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
		if(getText().equals(HIDDEN))
			setText(null);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//(123)123-1234
		String aux = "";
		char charAux = getText().charAt(getText().length()-1);
		if(getText().length()==3) {
			setText("("+getText()+")");
			return;
		}
		if(getText().length()==9) {
			for(int i=0;i<getText().length()-1;i++) {
				aux += getText().charAt(i);
			}
			setText(aux+"-"+charAux);
			return;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
