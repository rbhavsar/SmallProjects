package Util;

/**
 * @author rbhavsar
 * Created on 10/8/19.
 */
public class mainP {

  public static void main(String[] args) throws Exception {
    Validator val = new AdminValidator("Ravi","Bhavsar");
    ValidationUtils.validate(val);
    //System.out.println(val.validate());
  }
}
