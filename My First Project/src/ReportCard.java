import javafx.stage.StageStyle;

public class ReportCard {
			
	public char convertGrades(int testResult){
		
		char grade;
		
		if (testResult >= 90) {
			grade = 'A';
		}else if(testResult >=80 && testResult < 90) {
			grade = 'B';
		}else if(testResult >=70 && testResult < 80) {
			grade = 'C';
		}else {
			grade = 'D';
		}
		
		return grade;	
	}

	public static void main(String[] args) {
		ReportCard rc = new ReportCard();
		char yourGrade = rc.convertGrades(70);
		
		switch (yourGrade){
		case 'A':
			System.out.println("Превосходная работа!");
			break;
		case 'B':
			System.out.println("Хорошая работа!");
			break;
		case 'C':
			System.out.println("Так себе!");
			break;
		case 'D':
			System.out.println("Ебать ты лох!");
			break;
		}
		
		
	}

}
