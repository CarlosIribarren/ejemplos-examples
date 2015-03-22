import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {
	public static void main(String[] args) {
		// Create a panel
		JPanel windowContent= new JPanel();

		// Set a layout manager for this panel
		FlowLayout fl = new FlowLayout();
		windowContent.setLayout(fl);

		// Create controls in memory
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Sum:");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Add");
		
		/**go.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			    System.out.println("Tendría que hacer la suma");
			}
		});*/
		
		// Add controls to the panel
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		
		

		// Create the frame and add the panel to it
		JFrame frame = new JFrame("My First Calculator");
		
		// Add the panel to the top-level container
		frame.setContentPane(windowContent);
		
		// set the size and make the window visible
		frame.setSize(400,100);
		frame.setVisible(true);
	}
}

