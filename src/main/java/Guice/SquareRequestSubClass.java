package Guice;

import javax.inject.Inject;

/**
 * @author rbhavsar
 * Created on 10/11/19.
 */
public class SquareRequestSubClass extends SquareRequest{

  @Inject
  public SquareRequestSubClass(DrawShape d) {
    super(d);
  }

  @Override
  public void makeSquare(){
    System.out.println("Delegating call to draw method..");
    d.shape();
  }
}
