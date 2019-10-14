package UdemyJava.Collections.Theatre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rbhavsar
 * Created on 11/4/18.
 */
public class Theatre {

  private final String theatreName;
  private List<Seat> seats = new ArrayList<>();


  public Theatre(String theatreName,int numRows,int seatPerRow) {
    this.theatreName = theatreName;
    int lastRow = 'A'+(numRows-1);
    for(char row='A';row<=lastRow;row++){
      for(int seatNum=1;seatNum<=seatPerRow;seatNum++){
        Seat seat = new Seat(row+String.format("%2d",seatNum));
        seats.add(seat);
      }
    }
  }


  public boolean reserveSeat(String seatNumber){
    Seat requestSeat = null;
    for(Seat seat:seats){
      if(seat.getSeatNumber().equals(seatNumber)){
        requestSeat = seat;
        break;
      }
    }
    if(requestSeat==null){
      System.out.println("There is no seat "+seatNumber);
      return  false;
    }
    return requestSeat.reserved();
  }

  public void getSeats() {
    for (Seat seat : seats) {
      System.out.println(seat.getSeatNumber());
    }
  }

  private class Seat{

    private final String seatNumber;
    private boolean reserved = false;

    public String getSeatNumber() {
      return seatNumber;
    }

    public Seat(String seatNumber) {
      this.seatNumber=seatNumber;
    }

    public boolean reserved(){
      if(!this.reserved){
        this.reserved=true;
        System.out.println("Seat "+seatNumber+" reserved.");
        return true;
      }else{
        return false;
      }
    }

    public boolean cancel(){
      if(this.reserved){
        this.reserved=false;
        System.out.println("reservation of seatNumber "+seatNumber+ " Cancelled");
        return true;
      }
      else
      {
        return false;
      }
    }
  }
}
