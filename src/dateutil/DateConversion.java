package dateutil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConversion {
	
	public static Date convertingString(String date){
		String dt[] = date.split("/");
		Calendar calendar = new GregorianCalendar();
		calendar.set(Integer.parseInt(dt[2]),Integer.parseInt(dt[1])-1,Integer.parseInt(dt[0]));
		return calendar.getTime();
	}
	
}
