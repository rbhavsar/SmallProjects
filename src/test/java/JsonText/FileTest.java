package JsonText;


import java.io.File;
import java.io.FileOutputStream;

/**
 * @author rbhavsar
 * Created on 3/22/19.
 */
public class FileTest {

  public static void main(String[] args) {
    String filePath = "";
    createFile(filePath);
  }

  private static void createFile(String filePath) {

    File yourFile = new File("/Users/rbhavsar/apache-tomcat-9.0.14/logs/btm_documents/newFile.txt");
    try {
      yourFile.createNewFile(); // if file already exists will do nothing
      FileOutputStream oFile = new FileOutputStream(yourFile, false);
    }catch (Exception e){
      System.out.println(e.getMessage());
    }

  }
}
