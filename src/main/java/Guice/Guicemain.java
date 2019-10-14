package Guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author rbhavsar
 * Created on 10/11/19.
 */
public class Guicemain {


  /*
    1. consults binding to resolve the concrete type
    2. Build object of that type
    3.
   */

  public static void main(String[] args) {
//      Injector injector = Guice.createInjector(new AppModule());
//    DrawShape d = injector.getInstance(DrawShape.class);
//    //DrawSquare dr = new DrawSquare();
//    SquareRequest sq = new SquareRequest(d);
//    sq.makeSquare();

    Injector injector = Guice.createInjector(new AppModule());
    SquareRequest sq1 = injector.getInstance(SquareRequest.class);
    sq1.makeSquare();

    SquareRequest sq2 = injector.getInstance(SquareRequest.class);
    sq2.makeSquare();

    System.out.println(sq1.getDraShape() == sq2.getDraShape());


  }
}
