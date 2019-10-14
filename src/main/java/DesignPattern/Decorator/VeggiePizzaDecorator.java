package DesignPattern.Decorator;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class VeggiePizzaDecorator extends PizzaDecorator {

  public VeggiePizzaDecorator(Pizza pizza) {
    super(pizza);
  }

  public void bake(){
    super.bake();
    System.out.println("Adding Veggie toppings!");
  }
}
