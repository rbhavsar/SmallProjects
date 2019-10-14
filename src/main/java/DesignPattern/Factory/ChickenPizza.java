package DesignPattern.Factory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class ChickenPizza implements Pizza {
  @Override
  public void prepare() {
    System.out.println("Prepare Chicken Pizza");
  }

  @Override
  public void bake() {
    System.out.println("bake Chicken Pizza");
  }

  @Override
  public void cut() {
    System.out.println("cut Chicken Pizza");
  }
}
