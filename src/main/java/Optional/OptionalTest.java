package Optional;

import java.util.Optional;

/**
 * @author rbhavsar
 * Created on 2/13/19.
 */

/*
https://www.mkyong.com/java8/java-8-optional-in-depth/
Null checks are not required.
No more NullPointerException at run-time.
We can develop clean and neat APIs.
No more Boiler plate code
 */

public class OptionalTest {

  public static void main(String[] args) {

    //https://javarevisited.blogspot.com/2017/04/10-examples-of-optional-in-java-8.html
    //without optional
    Person p = new Person("Robin", new Address("city", "country"));
    Address a = p.getAddress();

    if(a != null){
      System.out.println(p);
    }

    //with optional
    Optional<Address> op = Optional.ofNullable(p.getAddress());
    if(!op.isPresent()){
      System.out.println(p);
    }

    






    Optional<String> gender = Optional.of("MALE");
    Optional<String> emptyGender = Optional.empty();
    String answer1 = "Yes";
    String answer2 = null;


    System.out.println("Non-Empty Optional:" + gender);


    gender
        .filter(g ->
            g.equals("male"));
    //Filter on Optional
    System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
    System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
    System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty


    if (gender.isPresent()) {
      System.out.println("Value available.");
    } else {
      System.out.println("Value not available.");
    }

    gender.ifPresent(g -> System.out.println("In gender Option, value available."));

    //condition failed, no output print
    emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));

  }

}
