package Util;


import java.util.StringTokenizer;

public class StringToArray {

  public static void main(String[] args) {

    String value = "ProductName,CategoryName"; // Add in properties file

    StringTokenizer str = new StringTokenizer(value,",");
    String data[] = new String[str.countTokens()];
    int i=0;
    while(str.hasMoreElements()){
      data[i] = str.nextToken();
      i++;
    }

    System.out.println(data[0]);
    System.out.println(data[1]);
  }


}
