package DesignPattern.AbtractFactory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class Test {

  public static void main(String[] args) {
    DaoAbtractFactory daf = DaoFactoryProducer.produce("xml"); //Factories of factory --> returns factrory daf
    Dao emp = daf.createDao("emp"); //factory.method -->> returns Dao
    emp.save();

  }
}
