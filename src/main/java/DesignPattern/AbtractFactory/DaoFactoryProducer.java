package DesignPattern.AbtractFactory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public class DaoFactoryProducer{

  public static DaoAbtractFactory produce(String factoryType){
    DaoAbtractFactory daf = null;
    if(factoryType.equals("xml")){
      daf = new XMLDaoFactory();
    }else if(factoryType.equals("db")){
      daf = new DBDaoFactory();
    }
    return daf;
  }


}
