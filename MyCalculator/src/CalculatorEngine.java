import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class CalculatorEngine implements ActionListener {

	public void actionPerformed (ActionEvent e){
		
		JOptionPane.showConfirmDialog(null, "Something  happened...", "Just a test", JOptionPane.PLAIN_MESSAGE);
		System.out.println("123");
	}
	
}
