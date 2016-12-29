import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CalculatorEngine implements ActionListener {

	public void actionPerformed (ActionEvent e){
		
		JFormattedTextField textField = null;
		JButton clickedButton = null;
		
		Object eSource = e.getSource();
		
		
		if (eSource instanceof JButton) {
			
			clickedButton = (JButton) eSource;
			
		} else if (eSource instanceof JFormattedTextField) {
			
			textField = (JFormattedTextField) eSource;
		}
		
		
		
		
		String clickedButtonLabel = clickedButton.getText();
		JOptionPane.showConfirmDialog(null, clickedButtonLabel + " was clicked.", "Clicked: " + clickedButtonLabel, JOptionPane.PLAIN_MESSAGE);
		//System.out.println(clickedButton);
		
	}
	
}
