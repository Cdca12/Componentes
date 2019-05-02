package componentes.componentesAuxiliares;


import java.awt.Color;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JLee extends JTextField implements FocusListener,KeyListener{
	private final String expCorreo = "^[a-z][a-z|0-9|_|.|-]{1,15}@[a-z]{2,8}\\.[a-z]{2,3}$";
	private final String expRFC = "^[A-Z]{4}[0-9]{6}[A-Z|0-9]{3}$";
	private final String expNumTel = "^\\([0-9]{3}\\)[0-9]{3}\\-[0-9]{4}$";
	private String exp;
	private int tipo;
	
	private boolean textoValido;
	private String exampleText;
	private Border colorDefault;
	private Color textoColorDefault;
	
	public JLee(int tipo) {
		this.tipo = tipo;
		
		switch(tipo) {
			case 1://correo
				exp = expCorreo;
				exampleText = "example@dir.com";
				break;
			case 2://RFC
				exp = expRFC;
				exampleText = "R F C";
				break;
			case 3://NumTel
				exp = expNumTel;
				exampleText = "(123)123-1234";
				break;
		}
		addFocusListener(this);
		addKeyListener(this);
		colorDefault = getBorder();
		textoColorDefault = getForeground();
		setText(exampleText);
		setForeground(new Color(142, 142, 142));
	}
	
	private boolean valida() {
		return getText().matches(exp);
	}
	public String getTextValidado() {
		if(tipo == 3 && textoValido) {
			return quitaFormato();
		}
		if(textoValido)
			return getText();
		return null;
	}
	private String quitaFormato() {
		String numeroInt="";
		String numeroString = getText();
		for(int i=0;i<numeroString.length();i++) 
			if(!(numeroString.charAt(i)=='(' || numeroString.charAt(i)==')' || numeroString.charAt(i)=='-'))
				numeroInt += numeroString.charAt(i);
		
		return numeroInt;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {		
		//Si no hay texto coloca nuevamente exampleText
		if(getText().length()==0) {
			setText(exampleText);
			setForeground(new Color(142, 142, 142));
		}
		if(valida()) {
			if(getText().equals(exampleText)){
				setBorder(colorDefault);
				return;
			}
			setBorder(BorderFactory.createLineBorder(new Color(46, 219, 0)));
			textoValido = true;
			return;
		}
		//si el texto es igual al ejemplo lo deja default
		if(getText().equals(exampleText)){
			setBorder(colorDefault);
			return;
		}
		setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		textoValido = false;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		setForeground(textoColorDefault);
		if(getText().equals(exampleText))
			setText(null);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		//RFC
		if(tipo == 2) {
			String min = getText();
			setText(min.toUpperCase());
			return;
		}
		//NumTel
		if(tipo == 3) {
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
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
