package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today, tomorrow;
		today = new Date(20, 3, 2018);
		tomorrow = new Date(21, 3, 2018);
		//Date otroDate= new Date (tomorrow);
		// if otrodate
		System.out.println(today + " isSameYear " + tomorrow + "? " + today.isSameYear(tomorrow));
	}

}


