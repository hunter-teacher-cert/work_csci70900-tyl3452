import java.time.LocalTime;

public class Time{
	
	public static void main(String[] args) {
		System.out.println("Eric Liu pre02 Time");
		
		
		int hour = 11;
		int minute = 10;
		int second = 40;
				
		//Calc numbers of seconds since midnight and output it
		int secondsSinceMidnight = (hour*60*60) + (minute*60) + second;
		System.out.printf("Seconds since midnight: %d\n", secondsSinceMidnight);
		
		//calc seconds reamining in day and output it
		final int TOTAL_SECONDS_IN_DAY = 86400;
		System.out.printf("Seconds remaining in day: %d\n", TOTAL_SECONDS_IN_DAY - secondsSinceMidnight);
		
		//calc percentage of day has passed
		System.out.printf("Percent of day has passed: %.2f%%\n",  (double) secondsSinceMidnight / TOTAL_SECONDS_IN_DAY * 100);
		
		//time since I started
		LocalTime currentTime = LocalTime.now();
		int elapsedSecs = (currentTime.getHour()*60*60) + (currentTime.getMinute()*60) + currentTime.getSecond() - secondsSinceMidnight;
		int secondElapsed = elapsedSecs % 60;
		int minuteElapsed = elapsedSecs / 60 ;
		int hourElapsed = elapsedSecs / 3600;
		
		System.out.printf("Time Elapsed - %d hour(s), %d minute(s), %d second(s)\n", hourElapsed, minuteElapsed, secondElapsed); 
		
		
		
	}//end main
}//end class