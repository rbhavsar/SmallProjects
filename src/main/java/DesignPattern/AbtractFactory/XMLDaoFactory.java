package DesignPattern.AbtractFactory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class XMLDaoFactory extends DaoAbtractFactory {
  @Override
  public Dao createDao(String type) {

    Dao dao = null;
    if(type.equals("emp")){
      dao = new XMLEmpDao();
    }else if(type.equals("dept")){
      dao = new XMLDeptDao();
    }
    return dao;
  }
}
