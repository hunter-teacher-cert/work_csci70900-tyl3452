//Eric Liu
//pre02

public class Date{
	
	
	
	public static void main(String[] args) {
		System.out.println("Eric Liu pre02");
	
		String day = "Tuesday";
		int date = 15;
		String month = "June";
		int year = 2021;
	
		System.out.println(day);
		System.out.println(date);
		System.out.println(month);
		System.out.println(year);
	
		// Output in AMerican format
		System.out.println("American format:");
		System.out.print(day + ", ");
		System.out.print(month + ' ');
		System.out.print(date + ", ");
		System.out.println(year);
	
		// Output in euro format
		System.out.println("European format:");
		System.out.print(day + " ");
		System.out.print(date + " ");
		System.out.print(month + " ");
		System.out.println(year);
	
	
	}//end main
	
}//end class