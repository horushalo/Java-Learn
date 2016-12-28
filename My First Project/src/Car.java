
public class Car {

	public void start() {
		System.out.println("Reactor online, weapons online, all systems nominal!");
	}
	
	public void stop() {
		System.out.println("Shutting down...");
	}
	
	public int drive(int howLong) {
		
		System.out.println("ћы ехали в течении " + howLong + " часов и проехали " + howLong*60 + " километров");
		
		return 0;
	}
	
}
