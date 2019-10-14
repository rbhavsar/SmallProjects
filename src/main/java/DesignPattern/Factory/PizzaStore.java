package DesignPattern.Factory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class PizzaStore {

  public Pizza orderPizza(String type){
    Pizza p = PizzaFactory.createPizza(type);
    p.prepare();
    p.bake();
    p.cut();

    return p;


  }

}

