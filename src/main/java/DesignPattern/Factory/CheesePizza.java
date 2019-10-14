package DesignPattern.Factory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class CheesePizza implements Pizza {


  @Override
  public void prepare() {
    System.out.println("prepare Cheese Pizza");
  }

  @Override
  public void bake() {
    System.out.println("bake Cheese Pizza");
  }

  @Override
  public void cut() {
    System.out.println("cut Cheese Pizza");
  }
}
