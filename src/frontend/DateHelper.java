package frontend;

import java.util.Date;

public class DateHelper {

	// difference between two Date objects rounded down to the nearest
	// second
	static public int differenceInSeconds(Date date1, Date date2){
		// find difference in milliseconds
		long timeDiff = date1.getTime() - date2.getTime();
		timeDiff = Math.abs(timeDiff);
		// convert to seconds
		return (int) (timeDiff / 1000);
	}
}
