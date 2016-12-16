package fuelCalc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class calculate {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Сколько топлива вошло?");
		float fuelBurned = input.nextInt();
		System.out.println("Сколько километров проехал?");
		float pathTraveled = input.nextInt();
		
		String formattedOutput = new DecimalFormat("#0.00").format((fuelBurned/pathTraveled)*100);
		
		System.out.println("Расход топлива: " + formattedOutput);

	}

}
