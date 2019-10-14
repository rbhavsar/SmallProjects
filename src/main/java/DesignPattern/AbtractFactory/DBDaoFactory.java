package DesignPattern.AbtractFactory;

/**
 * @author
 * Created on 10/29/18.
 */
public class DBDaoFactory extends DaoAbtractFactory{
  @Override
  public Dao createDao(String type) {
    Dao dao=null;
    if(dao.equals("emp")){
      dao = new DBEmpDao();
    }else if(dao.equals("dept")){
      dao = new DBDeptDao();
    }
    return dao;
  }
}
