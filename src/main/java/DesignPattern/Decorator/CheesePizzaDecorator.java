package DesignPattern.Decorator;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class CheesePizzaDecorator extends PizzaDecorator {

  public CheesePizzaDecorator(Pizza pizza) {
    super(pizza);
  }

  public void bake(){
    super.bake();
    System.out.println("Adding Cheese toppings!");
  }
}
