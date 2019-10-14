package DesignPattern.Template;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class Test {

  public static void main(String[] args) {
    DataRenderer dr = new XmlDataRenderer();
    System.out.println(dr.readData());
  }
}
