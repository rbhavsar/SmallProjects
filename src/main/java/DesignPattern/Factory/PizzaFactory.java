package DesignPattern.Factory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class PizzaFactory {

  public static Pizza createPizza(String type){
    Pizza p = null;

    if(type.equals("Cheese")){
      p = new CheesePizza();
    }else if(type.equals("Chicken")){
      p = new ChickenPizza();
    }else if(type.equals("Veggie")){
      p = new VeggiePizza();
    }
    return p;
  }

}
