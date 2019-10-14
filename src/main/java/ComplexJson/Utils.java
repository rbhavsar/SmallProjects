package ComplexJson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author rbhavsar
 * Created on 8/27/18.
 */
public class Utils {

  public static String readData(String filePath) throws IOException {
    File file = new File(filePath);
    StringBuilder sb = new StringBuilder();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String str;
    while ((str = br.readLine()) != null)
      sb.append(str);
    return sb.toString();
  }

}
