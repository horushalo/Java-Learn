import javax.swing.*;
import java.awt.*;

public class Calculator {

	JPanel windowContent;
	JTextField displayField;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	
	JButton buttonEqual;
	
	JButton buttonPlus;
	JButton buttonMinus;
	JButton buttonDivide;
	JButton buttonMultiply;
	
	
	JPanel p1;
	JPanel p2;
	
		Calculator() {
			
			windowContent = new JPanel();
			
			BorderLayout bl = new BorderLayout();
			windowContent.setLayout(bl);
			
			//displayField = new JTextField(20);
			displayField = new JFormattedTextField();
			displayField.setHorizontalAlignment(SwingConstants.RIGHT);
			windowContent.add("North", displayField);
			
			
			// Cycle replaces individual construction of each button 
			JButton[] buttons= new JButton[10];
			for (int i = 0; i < buttons.length; i++) {
				buttons[i] = new JButton(String.valueOf(i));
			}
			
			/*
			button0 = new JButton("0");
			button1 = new JButton("1");
			button2 = new JButton("2");
			button3 = new JButton("3");
			button4 = new JButton("4");
			button5 = new JButton("5");
			button6 = new JButton("6");
			button7 = new JButton("7");
			button8 = new JButton("8");
			button9 = new JButton("9");
			*/
			// END
			
			buttonPoint = new JButton(".");
			buttonEqual = new JButton("=");
			buttonPlus = new JButton("+");
			buttonMinus = new JButton("-");
			buttonDivide = new JButton("/");
			buttonMultiply = new JButton("*");
			
			p1 = new JPanel();
			GridLayout gl = new GridLayout(4,3);
			p1.setLayout(gl);
			
			// Cycle replaces individual buttons adding
			for (int i = 0; i < buttons.length; i++) {
				p1.add(buttons[i]);
			}
			
			/*
			p1.add(button0);
			p1.add(button1);
			p1.add(button2);
			p1.add(button3);
			p1.add(button4);
			p1.add(button5);
			p1.add(button6);
			p1.add(button7);
			p1.add(button8);
			p1.add(button9);
			*/
			// END
			
			p1.add(buttonPoint);
			p1.add(buttonEqual);
			
			
			p2 = new JPanel();
			GridLayout gl2 = new GridLayout(4, 1);
			p2.setLayout(gl2);
			
			p2.add(buttonPlus);
			p2.add(buttonMinus);
			p2.add(buttonDivide);
			p2.add(buttonMultiply);
			
			
			
			
			windowContent.add("Center", p1);
			windowContent.add("East", p2);
			JFrame frame = new JFrame("Calculator");
			frame.setContentPane(windowContent);
			
			frame.pack();
			
			frame.setVisible(true);
			
		}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
	}

}
