package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		String stringDate = date.toString();
		String NoSpaceStringDate = stringDate.replaceAll("\\s", "");
		String NoColonStringDate = NoSpaceStringDate.replaceAll("\\:", "");
		System.out.println(NoColonStringDate+"@gmail.com");
		
	}

}
