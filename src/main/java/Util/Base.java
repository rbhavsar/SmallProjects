package Util;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

class Base {
  public void fun1() {
    System.out.println("Base fun1");
  }
  public void fun() {
    System.out.println("Base fun");
  }
}

class Derived extends Base {
  public void fun() {
    System.out.println("Derived fun");
  }
  public static void main(String[] args) {
    String s1=new String("Birst");
    String s2=new String("Birst");
    System.out.println(s1==s2); //false
    System.out.println(s1.equals(s2)); //true


    StudentData std1 = new StudentData("H1");
    StudentData std2 = new StudentData("H1");
    System.out.println(std1==std2); //false
    System.out.println(std1.equals(std2)); //false

    String text = "fab9006e-f5f0-4c27-a71c-7805fdff2e17?SecurityRoleMaster&amp;verb=Process";
    String[] split = text.split(text,'?');
    System.out.println(split[0]);

    System.out.println( "Now: " + new DateTime( DateTimeZone.UTC ) );

    long TICKS_AT_EPOCH = 621355968000000000L;
    long tick = System.currentTimeMillis()*10000 + TICKS_AT_EPOCH;
    System.out.println("tick: "+tick);
  }

  private static class StudentData {
    String name;
    public StudentData(String name) {
      this.name=name;
    }
  }
}
