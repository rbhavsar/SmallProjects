package UdemyJava.Generics.Players;

/**
 * @author rbhavsar
 * Created on 11/4/18.
 */
public class Main {

  public static void main(String[] args) {
    FootballPlayer joe = new FootballPlayer("Joe");
    BaseBallPlayer pat = new BaseBallPlayer("Pat");
    SoccerPlayer beckham = new SoccerPlayer("Backham");

    Team<FootballPlayer> crows = new Team("Crows");
    crows.addPlayer(joe);
    //    crows.addPlayer(pat);
    //    crows.addPlayer(beckham);

    Team<BaseBallPlayer> base = new Team("BaseTeam");
    base.addPlayer(pat);
    //    Team<String> extra = new Team("Extra");
    //    extra.addPlayer("noone");

    Team<SoccerPlayer> soccer = new Team("SoccerTeam");
    soccer.addPlayer(beckham);

    Team<FootballPlayer> foot1 = new Team("foot1");
    Team<FootballPlayer> foot2 = new Team("foot2");

    foot1.matchResult(foot2,1,0);

    System.out.println("ranking1 :- "+foot1.ranking());
    System.out.println("ranking2 :- "+foot2.ranking());

    System.out.println(foot1.compareTo(foot2));
    System.out.println(foot2.compareTo(foot1));

    League<Team<FootballPlayer>> league = new League<>("league1");
    league.addLeague(foot1);
    league.showLeagueTable();
   // Collections.sort();


  }




}
