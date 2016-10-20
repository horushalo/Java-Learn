
public class Pet {
	
	int age;
	float weight;
	float height;
	String color;

	public void sleep() {
		System.out.println("Спокойной ночи! до завтра!");
	}
	public void eat() {
		System.out.println("Я хочу есть!");
	}
	public String say(String aWord) {
		String petResponse = "Ну ладно!! " +aWord ;
		return petResponse;
	}
}
