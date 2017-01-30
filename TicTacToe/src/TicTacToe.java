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
	 * Конструктор апплета
	 */
	public void init(){
		
		// Устанавливаем менеджер расположения апплета, шрифт и цвет
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN);
		
		//Ставим жирный шрифт апплета с размером 20
		
		Font appletFont = new Font("Monospaced",Font.BOLD, 20);
		this.setFont(appletFont);
		
		// создаем кнопку "New game" и регистрируем в ней слушатель действия
		
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
			
		// Создаем массив, чтобы хранить ссылки на 9 кнопок
			
			squares = new Button[9];
			
		// Создаем кнопки, сохраняем ссылки на них в массиве
		// регистрируем в них слушатель, красим их
		// в оранжевый цвет и добавляем на панель
			
			for (int i=0;i<9;i++){
				
				squares[i] = new Button();
				squares[i].addActionListener(this);
				squares[i].setBackground(Color.ORANGE);
				centerPanel.add(squares[i]);
				
			}
	}

	/**
	 * Этот метод будет обрабатывать все события
	 * @param ActionEvent объект
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		Button theButton = (Button) e.getSource();
		
		// Это кнопка New game?
		
		if (theButton == newGameButton) {
			
			for(int i=0;i<9;i++){
				
				squares[i].setEnabled(true);
				squares[i].setLabel("");
				squares[i].setBackground(Color.ORANGE);
			}
			
			emptySquaresLeft=9;
			score.setText("Your turn!");
			newGameButton.setEnabled(false);
			return; //выходим из метода
		}
		
		String winner = "";
		
		// Это одна из клеток?
		
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
			
		} // конец цикла for
		
		if (winner.equals("X")) {
			score.setText("You won!");
		} else if (winner.equals("O")) {
			score.setText("You lost!");
		} else if (winner.equals("T")) {
			score.setText("It's a tie!");
		}
		
	} // конец метода actionPerformed
	
	/**
	 * Этот метод вызывается после каждого хода, чтобы узнать,
	 * есть ли победитель. Он проверяет каждый ряд, колонку
	 * и диагональ, чтобы найти три клетки с одинаковыми надписями (не пустыми)
	 * @return "X", "O", "T" - ничья, "" - еще нет победителя
	 */
	
	String lookForWinner() {
		
		String theWinner = "";
		emptySquaresLeft--;
		if (emptySquaresLeft==0) {
			return "T"; // ничья
		}
		
		// проверяем ряд 1 - элементы массива 0,1,2
		if (!squares[0].getLabel().equals("") &&
				
			squares[0].getLabel().equals(squares[1].getLabel()) && 
			squares[0].getLabel().equals(squares[2].getLabel())) {
			
			theWinner = squares[0].getLabel();
			highlightWinner(0,1,2);
			
		// проверяем ряд 2 - элементы массива 3,4,5
		} else if (!squares[3].getLabel().equals("") &&
			
			squares[3].getLabel().equals(squares[4].getLabel()) &&
			squares[3].getLabel().equals(squares[5].getLabel())) {
			
			theWinner = squares[3].getLabel();
			highlightWinner(3,4,5);
			
		// проверяем ряд 3 - элементы массива 6,7,8
		} else if ( ! squares[6].getLabel().equals("") &&
				
			squares[6].getLabel().equals(squares[7].getLabel()) &&
			squares[6].getLabel().equals(squares[8].getLabel())) {
			
			theWinner = squares[6].getLabel();
			highlightWinner(6,7,8);
			
		// Проверяем колонку 1 – элементы массива 0,3,6
		} else if ( ! squares[0].getLabel().equals("") &&
					
			squares[0].getLabel().equals(squares[3].getLabel()) &&
			squares[0].getLabel().equals(squares[6].getLabel())) {
			
			theWinner = squares[0].getLabel();
			highlightWinner(0,3,6);
			
		// Проверяем колонку 2 – элементы массива 1,4,7
		} else if ( ! squares[1].getLabel().equals("") &&
			squares[1].getLabel().equals(squares[4].getLabel()) &&
			squares[1].getLabel().equals(squares[7].getLabel())) {
				
			theWinner = squares[1].getLabel();
			highlightWinner(1,4,7);
				
		// Проверяем колонку 3 – элементы массива 2,5,8
		} else if ( ! squares[2].getLabel().equals("") &&
				
			squares[2].getLabel().equals(squares[5].getLabel()) &&
			squares[2].getLabel().equals(squares[8].getLabel())) {
			
			theWinner = squares[2].getLabel();
			highlightWinner(2,5,8);
			
		// Проверяем первую диагональ – элементы массива 0,4,8
		} else if ( ! squares[0].getLabel().equals("") &&
				
			squares[0].getLabel().equals(squares[4].getLabel()) &&
			squares[0].getLabel().equals(squares[8].getLabel())) {
			
			theWinner = squares[0].getLabel();
			highlightWinner(0,4,8);
		
		// Проверяем вторую диагональ – элементы массива 2,4,6
		} else if ( ! squares[2].getLabel().equals("") &&
			
			squares[2].getLabel().equals(squares[4].getLabel()) &&
			squares[2].getLabel().equals(squares[6].getLabel())) {
				
			theWinner = squares[2].getLabel();
			highlightWinner(2,4,6);
		}
		
		return theWinner;
	}
	
	/**
	* Этот метод применяет набор правил, чтобы найти
	* лучший компьютерный ход. Если хороший ход
	* не найден, выбирается случайная клетка.
	*/
	
	void computerMove() {
		
		int selectedSquare;
		
		// Сначала компьютер пытается найти пустую клетку
		// рядом с двумя клетками с ноликами, чтобы выиграть
		
		selectedSquare = findEmptySquare("O");
		
		// Если он не может найти два нолика, то хотя бы
		// попытается не дать оппоненту сделать ряд из 3-х
		// крестиков,поместив нолик рядом с двумя крестиками
		
		if (selectedSquare == -1)
			
			selectedSquare = findEmptySquare("X");
	}
	
	// если selectedSquare все еще равен -1, то
	// попытается занять центральную клетку
	
	if ( (selectedSquare == -1) && (squares[4].getLabel().equals("")) ){
		
		selectedSquare=4;
	}
	
	// не повезло с центральной клеткой...
	// просто занимаем случайную клетку
	
	if (selectedSquare == -1) {
		
		selectedSquare = getRandomSquare();
	}
	
	squares[selectedSquare].setlabel("O");

}

/**
* Этот метод проверяет каждый ряд, колонку и диагональ
* чтобы узнать, есть ли в ней две клетки
* с одинаковыми надписями и пустой клеткой.
* @param передается X – для пользователя и O – для компа
* @return количество свободных клеток,
* или -1, если не найдено две клетки
* с одинаковыми надписями
*/




}










