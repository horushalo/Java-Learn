import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.Highlighter.Highlight;

public class TicTacToe extends Applet implements ActionListener{

	Button squares[];
	Button newGameButton;
	Label score;
	int emptySquaresLeft=9;
	
	/*
	 * ����������� �������
	 */
	public void init(){
		
		// ������������� �������� ������������ �������, ����� � ����
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN);
		
		//������ ������ ����� ������� � �������� 20
		
		Font appletFont = new Font("Monospaced",Font.BOLD, 20);
		this.setFont(appletFont);
		
		// ������� ������ "New game" � ������������ � ��� ��������� ��������
		
		newGameButton = new Button("New game");
		newGameButton.addActionListener(this);
		
		Panel topPanel = new Panel();
		
		topPanel.add(newGameButton);
			this.add(topPanel,"North");
			
			Panel centerPanel = new Panel();
			centerPanel.setLayout(new GridLayout(3,3));
			this.add(centerPanel,"Center");
			
			score = new Label("Your turn!");
			this.add(score,"South");
			
		// ������� ������, ����� ������� ������ �� 9 ������
			
			squares = new Button[9];
			
		// ������� ������, ��������� ������ �� ��� � �������
		// ������������ � ��� ���������, ������ ��
		// � ��������� ���� � ��������� �� ������
			
			for (int i=0;i<9;i++){
				
				squares[i] = new Button();
				squares[i].addActionListener(this);
				squares[i].setBackground(Color.ORANGE);
				centerPanel.add(squares[i]);
				
			}
	}

	/**
	 * ���� ����� ����� ������������ ��� �������
	 * @param ActionEvent ������
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		Button theButton = (Button) e.getSource();
		
		// ��� ������ New game?
		
		if (theButton == newGameButton) {
			
			for(int i=0;i<9;i++){
				
				squares[i].setEnabled(true);
				squares[i].setLabel("");
				squares[i].setBackground(Color.ORANGE);
			}
			
			emptySquaresLeft=9;
			score.setText("Your turn!");
			newGameButton.setEnabled(false);
			return; //������� �� ������
		}
		
		String winner = "";
		
		// ��� ���� �� ������?
		
		for (int i=0; i<0; i++){
			
			if (theButton == squares[i]) {
				
				squares[i].setLabel("X");
				winner = lookForWinner();
				
				if (!"".equals(winner)) {
					endTheGame();
				} else {
					
					computerMove();
					winner = lookForWinner();
					
					if (!"".equals(winner)){
						endTheGame();
					}
				}
				
			break;
				
			}
			
		} // ����� ����� for
		
		if (winner.equals("X")) {
			score.setText("You won!");
		} else if (winner.equals("O")) {
			score.setText("You lost!");
		} else if (winner.equals("T")) {
			score.setText("It's a tie!");
		}
		
	} // ����� ������ actionPerformed
	
	/**
	 * ���� ����� ���������� ����� ������� ����, ����� ������,
	 * ���� �� ����������. �� ��������� ������ ���, �������
	 * � ���������, ����� ����� ��� ������ � ����������� ��������� (�� �������)
	 * @return "X", "O", "T" - �����, "" - ��� ��� ����������
	 */
	
	String lookForWinner() {
		
		String theWinner = "";
		emptySquaresLeft--;
		if (emptySquaresLeft==0) {
			return "T"; // �����
		}
		
		// ��������� ��� 1 - �������� ������� 0,1,2
		if (!squares[0].getLabel().equals("") &&
				
			squares[0].getLabel().equals(squares[1].getLabel()) && 
			squares[0].getLabel().equals(squares[2].getLabel())) {
			
			theWinner = squares[0].getLabel();
			highlightWinner(0,1,2);
			
		// ��������� ��� 2 - �������� ������� 3,4,5
		} else if (!squares[3].getLabel().equals("") &&
			
			squares[3].getLabel().equals(squares[4].getLabel()) &&
			squares[3].getLabel().equals(squares[5].getLabel())) {
			
			theWinner = squares[3].getLabel();
			highlightWinner(3,4,5);
			
		// ��������� ��� 3 - �������� ������� 6,7,8
		} else if ( ! squares[6].getLabel().equals("") &&
				
			squares[6].getLabel().equals(squares[7].getLabel()) &&
			squares[6].getLabel().equals(squares[8].getLabel())) {
			
			theWinner = squares[6].getLabel();
			highlightWinner(6,7,8);
			
		// ��������� ������� 1 � �������� ������� 0,3,6
		} else if ( ! squares[0].getLabel().equals("") &&
					
			squares[0].getLabel().equals(squares[3].getLabel()) &&
			squares[0].getLabel().equals(squares[6].getLabel())) {
			
			theWinner = squares[0].getLabel();
			highlightWinner(0,3,6);
			
		// ��������� ������� 2 � �������� ������� 1,4,7
		} else if ( ! squares[1].getLabel().equals("") &&
			squares[1].getLabel().equals(squares[4].getLabel()) &&
			squares[1].getLabel().equals(squares[7].getLabel())) {
				
			theWinner = squares[1].getLabel();
			highlightWinner(1,4,7);
				
		// ��������� ������� 3 � �������� ������� 2,5,8
		} else if ( ! squares[2].getLabel().equals("") &&
				
			squares[2].getLabel().equals(squares[5].getLabel()) &&
			squares[2].getLabel().equals(squares[8].getLabel())) {
			
			theWinner = squares[2].getLabel();
			highlightWinner(2,5,8);
			
		// ��������� ������ ��������� � �������� ������� 0,4,8
		} else if ( ! squares[0].getLabel().equals("") &&
				
			squares[0].getLabel().equals(squares[4].getLabel()) &&
			squares[0].getLabel().equals(squares[8].getLabel())) {
			
			theWinner = squares[0].getLabel();
			highlightWinner(0,4,8);
		
		// ��������� ������ ��������� � �������� ������� 2,4,6
		} else if ( ! squares[2].getLabel().equals("") &&
			
			squares[2].getLabel().equals(squares[4].getLabel()) &&
			squares[2].getLabel().equals(squares[6].getLabel())) {
				
			theWinner = squares[2].getLabel();
			highlightWinner(2,4,6);
		}
		
		return theWinner;
	}
	
	/**
	* ���� ����� ��������� ����� ������, ����� �����
	* ������ ������������ ���. ���� ������� ���
	* �� ������, ���������� ��������� ������.
	*/
	
	void computerMove() {
		
		int selectedSquare;
		
		// ������� ��������� �������� ����� ������ ������
		// ����� � ����� �������� � ��������, ����� ��������
		
		selectedSquare = findEmptySquare("O");
		
		// ���� �� �� ����� ����� ��� ������, �� ���� ��
		// ���������� �� ���� ��������� ������� ��� �� 3-�
		// ���������,�������� ����� ����� � ����� ����������
		
		if (selectedSquare == -1)
			
			selectedSquare = findEmptySquare("X");
	}
	
	// ���� selectedSquare ��� ��� ����� -1, ��
	// ���������� ������ ����������� ������
	
	if ( (selectedSquare == -1) && (squares[4].getLabel().equals("")) ){
		
		selectedSquare=4;
	}
	
	// �� ������� � ����������� �������...
	// ������ �������� ��������� ������
	
	if (selectedSquare == -1) {
		
		selectedSquare = getRandomSquare();
	}
	
	squares[selectedSquare].setlabel("O");

}

/**
* ���� ����� ��������� ������ ���, ������� � ���������
* ����� ������, ���� �� � ��� ��� ������
* � ����������� ��������� � ������ �������.
* @param ���������� X � ��� ������������ � O � ��� �����
* @return ���������� ��������� ������,
* ��� -1, ���� �� ������� ��� ������
* � ����������� ���������
*/




}










