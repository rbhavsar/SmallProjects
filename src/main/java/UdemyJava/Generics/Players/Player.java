package UdemyJava.Generics.Players;

/**
 * @author rbhavsar
 * Created on 11/4/18.
 */
public abstract class Player {

  private String name;

  public Player(String name){
    this.name=name;
  }

  public String getName(){
    return name;
  }
}
