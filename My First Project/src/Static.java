
public class Static {

	public static void main(String[] args) {
		
		String players[] = new String[8];
		
		players[0] = "Anna";
		players[1] = "Bob";
		players[2] = "Cindy";
		players[3] = "Elise";
		players[4] = "Frank";
		players[6] = "Edna!!!";
		
		int totalPlayers = players.length;
		int counter=0;
	
		while (counter < totalPlayers){
			
			String thePlayer = players[counter];
			
			if (thePlayer == null){
				continue;
			}
			System.out.println(thePlayer);
			counter++;
		}
		

	}

}
