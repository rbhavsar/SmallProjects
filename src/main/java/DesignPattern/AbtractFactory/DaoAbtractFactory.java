package DesignPattern.AbtractFactory;

/**
 * @author rbhavsar
 * Created on 10/29/18.
 */
public abstract class DaoAbtractFactory {

  public abstract Dao createDao(String type);
}
