
public class Fish extends Pet {

	int currentDepth = 0;
	
	public int dive(int howDeep){
		currentDepth=currentDepth + howDeep;
		
		if (currentDepth > 100) {
			
			System.out.println("Я не могу нырять глубже 100 метров!");
			currentDepth=currentDepth - howDeep;
		}else{
			
			System.out.println("ныряю на глубину " + howDeep + " футов");
			System.out.println("Я на глубине " + currentDepth + " футов ниже уровня моря");
			
		}
		
		return currentDepth;
	}
	
	public String say (String aWord){
		String replacement = "Ты чё не знаешь, что рыбы не разговаривают?";
		//System.out.println(replacement);
		return replacement;
		}
	
}
