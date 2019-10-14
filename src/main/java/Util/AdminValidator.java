package Util;

/**
 * @author rbhavsar
 * Created on 10/8/19.
 */
public class AdminValidator implements Validator {

  String fname;
  String lname;

  public AdminValidator (String fname,String lname){
    this.fname = fname;
    this.lname = lname;
  }

  @Override
  public String validate() {
    return fname+":"+lname;
  }
}
