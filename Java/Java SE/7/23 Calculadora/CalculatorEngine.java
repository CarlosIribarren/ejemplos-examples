import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorEngine implements MouseListener {

	private Calculadora parent;
	
	public CalculatorEngine() {}
	// Constructor stores the reference to the
	// Calculator window in the member variable parent
	public CalculatorEngine(Calculadora parent){
		this.parent = parent;
	}

	/*
	//Acción básica
	public void actionPerformed(ActionEvent e){
		JOptionPane.showConfirmDialog(null,
				"Something happened...",
				"Just a test",
				JOptionPane.PLAIN_MESSAGE);

	}
	*/
	
	//Acción media
	
	public void actionPerformed(ActionEvent e){
		// Get the source of this action
		// SI LA FUENTE PUEDE SER != DE JBUTTON TENDREMOS QUE USAR INSTANCEOF
		JButton clickedButton= (JButton) e.getSource();
		// Get the button’s label
		String clickedButtonLabel = clickedButton.getText();
		// Concatenate the button’s label
		// to the text of the message box
		JOptionPane.showConfirmDialog(null,
				"You pressed " + clickedButtonLabel,
				"Just a test",
				JOptionPane.PLAIN_MESSAGE);
	}
	
	//Acción avanzada
	/*
	public void actionPerformed(ActionEvent e){
		// Get the source of this action
		JButton clickedButton = (JButton) e.getSource();
		// Get the existing text from the Calculator’s
		// display field. Reaching inside another object is bad.
		String dispFieldText = parent.getDisplayValue();
		
		//NO USAR LO SIGUIENTE POR SALTARSE PRINCIPIOS DE O.O.
		//String dispFieldText = parent.getDisplayField().getText();
		
		// Get the button’s label
		String clickedButtonLabel = clickedButton.getText();
		parent.setDisplayValue(dispFieldText + clickedButtonLabel);
	}
*/
	
	public Calculadora getParent() {
		return parent;
	}

	public void setParent(Calculadora parent) {
		this.parent = parent;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}