package DesignPattern.Decorator;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class PlainPizza implements Pizza {
  @Override
  public void bake() {
    System.out.println("baking plain pizza!");
  }
}
