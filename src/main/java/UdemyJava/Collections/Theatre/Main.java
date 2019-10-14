package UdemyJava.Collections.Theatre;

/**
 * @author rbhavsar
 * Created on 11/4/18.
 */
public class Main {

  public static void main(String[] args) {
    Theatre theatre = new Theatre("25 Cen",8,12);
    theatre.getSeats();

    if(theatre.reserveSeat("H11")){
      System.out.println("Please pay");
    }else{
      System.out.println("Seat if already reserved.");
    }

    if(theatre.reserveSeat("H11")){
      System.out.println("Please pay");
    }else{
      System.out.println("Seat if already reserved.");
    }
  }
}
