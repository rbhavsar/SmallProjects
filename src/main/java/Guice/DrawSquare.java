package Guice;

/**
 * @author rbhavsar
 * Created on 10/11/19.
 */
public class DrawSquare implements DrawShape{
  @Override
  public void shape() {
    System.out.println("Drawing square!");
  }
}
