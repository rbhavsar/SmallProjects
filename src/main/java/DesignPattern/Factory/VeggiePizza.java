package DesignPattern.Factory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class VeggiePizza implements Pizza{
  @Override
  public void prepare() {
    System.out.println("prepare veggie pizza");
  }

  @Override
  public void bake() {
    System.out.println("bake veggie pizza");
  }

  @Override
  public void cut() {
    System.out.println("cut veggie pizza");
  }
}
