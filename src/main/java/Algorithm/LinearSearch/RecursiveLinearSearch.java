package Algorithm.LinearSearch;

/**
 * @author rbhavsar
 * Created on 11/28/18.
 */
public class RecursiveLinearSearch {


  public static void main(String[] args) {
    System.out.println(recursiveLinearSearch(new int[]{1,4,7,9,12,45},0,9));
  }

  private static int recursiveLinearSearch(int[] a, int i, int x) {
    if(i>a.length-1){
      return -1;
    }else if(a[i]==x){
      return i;
    }else{
      System.out.println("index: "+i);
      return recursiveLinearSearch(a,i+1,x);
    }
  }

}
