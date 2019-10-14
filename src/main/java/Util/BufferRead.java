package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author rbhavsar
 * Created on 8/11/18.
 */
public class BufferRead {

  public static void main(String args[]) throws IOException {
    FileReader fr = null;
    try {
      fr = new FileReader("/Users/rbhavsar/SmallProjects/car1saa.json");
      BufferedReader br = new BufferedReader(fr);

      int i;
      while ((i = br.read()) != -1) {
        System.out.print((char) i);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.out);
      System.out.println(e.getLocalizedMessage());
      System.out.println(e.getCause());
      System.out.println(e.getMessage());
    }

    //br.close();
    //fr.close();
  }

}
