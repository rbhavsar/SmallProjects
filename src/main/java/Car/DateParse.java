package Car;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author rbhavsar
 * Created on 5/24/19.
 */
public class DateParse {
  public static void main(String[] args) {

    java.sql.Timestamp str = Timestamp.valueOf("2019-05-20 23:42:02.234");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
    String dateTime = sdf.format(str.getTime());
    System.out.println("dateTime: "+dateTime);
  }

}


//  SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss aa", Locale.ENGLISH);
//
//
//  String dateInString = "2019-05-23 12:55:15";
//  Date date = formatter.parse(dateInString);
//  String formattedDateString = formatter.format(date);
//    System.out.println(formattedDateString);
