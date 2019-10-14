package UdemyJava.Generics.Players;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author rbhavsar
 * Created on 11/4/18.
 */
public class League<T extends Team> {

  public String name;
  public String getName() {
    return name;
  }

  public League(String name){
    this.name = name;
  }

  private ArrayList<T> league = new ArrayList<>();

  public boolean addLeague(T team){
    if(league.contains(team)){
      return false;
    }else{
      league.add(team);
      return true;
    }
  }

  public void showLeagueTable(){
    Collections.sort(league);
    for(T t:league){
      System.out.println(t.getName() +" : "+t.ranking());
    }
  }


}
