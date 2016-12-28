
public class TemperatureConverter {

	
	public String convertTemp(int temperature, char convertTo){
		
		double result;
		
		switch (convertTo) {
		case 'C':
			result = (temperature - 32) / 1.8;
			System.out.println(temperature + " по фаренгейту это " + result + " по цельсию.");
			break;

		case 'F':
			result = temperature * 1.8 + 32;
			System.out.println(temperature + " по цельсию это " + result + " по фаренгейту.");
			break;
		}
		
		return "";
	}
	
	
	public static void main(String[] args) {
		
		TemperatureConverter myTC = new TemperatureConverter();
		
		myTC.convertTemp(451, 'C');

	}

}
