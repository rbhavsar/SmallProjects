package DataStructure.Sorting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class InsertionSort {

  public static void main(String[] args) {


    List<String> spaceIds = Arrays.asList("Milan",
        "London",
        "New York",
        "San Francisco");

    String citiesCommaSeparated = String.join(",", spaceIds);
    StringBuilder sb=new StringBuilder();

    for (int counter=0;counter<spaceIds.size();counter++) {
      sb.append("\""+spaceIds.get(counter)+"\"");
      if(counter!=spaceIds.size()-1)
      sb.append(",");
    }

    System.out.println(sb.toString());

    Map<String,String> map = new HashMap<String,String>();
    map.put("conn","");

    for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
      System.out.println(stringStringEntry.getValue().toLowerCase());
    }

    map.get("test");

    int[] myArray = insertionSort(new int[]{10,1,3,20,5});
    for (int i : myArray) {
      System.out.println(i);
    }


    File yourFile = new File("score.txt");
    try {
      yourFile.createNewFile(); // if file already exists will do nothing
      FileOutputStream oFile = new FileOutputStream(yourFile, false);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static int[] insertionSort(int[] a){
    for(int i=1;i<a.length;i++){
      int element = a[i];// element variabe contains data we intend
      int j=i-1; // last value in the sorted area
      while(j>=0 && a[j]>element){
        a[j+1]=a[j];
        j--;
      }
      a[j+1]=element;
   }
    return a;
  }
}
