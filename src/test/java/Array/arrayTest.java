package Array;

public class arrayTest extends baseTest {

  public static void main(String[] args) {
    String myString="उत्पाद";
    boolean isHindi = false;
    for (char c: myString.toCharArray()) {
      if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.DEVANAGARI) {
        isHindi = true;
        break;
      }
    }
  }




}
