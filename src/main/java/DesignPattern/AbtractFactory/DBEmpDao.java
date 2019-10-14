package DesignPattern.AbtractFactory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class DBEmpDao implements Dao{
  @Override
  public void save() {

    System.out.println("Saving Employee to Database");
  }
}
