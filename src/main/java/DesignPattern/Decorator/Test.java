package DesignPattern.Decorator;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class Test {

  public static void main(String[] args) {
    Pizza pizza = new CheesePizzaDecorator(new PlainPizza());
    pizza.bake();


    pizza = new VeggiePizzaDecorator(new PlainPizza());
    pizza.bake();

  }
}

