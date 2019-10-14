package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.split;

/**
 * @author rbhavsar
 * Created on 8/19/18.
 */
public class condingChallenge {

  public static void main(String[] args) {
    //System.out.println(singlenumber(new int[]{2,2,4,4,7}));
    //System.out.println(searchInsert(new int[]{1,3,5,6},0));
   //moveZeroes(new int[]{0,1,0,3,1});
   //findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    //System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    //findDuplicate(new int[]{1,3,4,2,2});
    //firstUniqChar("leetcode");
    //System.out.println(longestCommonPrefix(new String[]{"abaa","abaab","abaaa"}));
    //System.out.println(myAtoi("123@%^123"));
    //System.out.println(reverseNumber(-121));
    //System.out.println(strStr("goodtecher","tech"));
    //System.out.println(fizzBuzz(15));
    //System.out.println(reverseThisNumber(1534236469));
    //removeDuplicates(new int[]{1,1,2});
    //System.out.println(sqrt(67));
    DuplicateString("I am am java java dev");

  }

  private static void DuplicateString(String str) {
    findDuplicateWord(str);
  }

  private static void findDuplicateWord(String str) {
    String[] split = split(str," ");
    Map<String,Integer> hashmap = new HashMap<String,Integer>();
    for (String s : split) {
      if(hashmap.get(s) != null){
        hashmap.put(s,hashmap.get(s)+1);
      }else {
        hashmap.put(s, 1);
      }
    }
    System.out.println(hashmap);
//    Iterator<String> iterator = hashmap.keySet().iterator();
//    while(iterator.hasNext()){
//      String next = iterator.next();
//      if(hashmap.get(next) > 1){
//        System.out.println(next+ " appeared "+hashmap.get(next) + " times." );
//      }
//    }

//    Set<Map.Entry<String, Integer>> entries = hashmap.entrySet();
//    for (Map.Entry<String, Integer> entry : entries) {
//      if(entry.getValue() > 1){
//        System.out.println(entry.getKey() +" appeared "+entry.getValue()+ " times");
//      }
//    }

//     for (String key: hashmap.keySet()){
//       if(hashmap.get(key) > 1){
//         System.out.println(hashmap.get(key)+ ":"+key);
//       }
//     }

    Iterator<Map.Entry<String, Integer>> iterator = hashmap.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String, Integer> next = iterator.next();
      if(next.getValue()  > 1){
        System.out.println(next.getKey() + ":"+next.getValue());
      }
    }

  }

  private static int sqrt(int x) {

    // Base cases
    if (x == 0 || x == 1)
      return x;

    // Staring from 1, try all numbers until
    // i*i is greater than or equal to x.
    int i = 1, result = 1;

    while (result <= x) {
      i++;
      result = i * i;
    }
    return i - 1;

  }

  private static int reverseThisNumber(int num) {

    /*if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
      return 0;
    }*/
    int reverseNumber =0;

    while(num!=0){
      if (reverseNumber > Integer.MAX_VALUE/10 || (reverseNumber == Integer.MAX_VALUE / 10 && reverseNumber*10 > 7)) return 0;
      if (reverseNumber < Integer.MIN_VALUE/10 || (reverseNumber == Integer.MIN_VALUE / 10 && reverseNumber*10 < -8)) return 0;

      reverseNumber = num%10+reverseNumber*10; // 321
      num = num/10;// 1
    }
    return reverseNumber;
  }



  private static List<String> fizzBuzz(int num) {
    List<String> list = new ArrayList<String>();
    for(int i=1;i<=num;i++){
      if(i%3==0 && i%5==0){
      list.add("FizzBuzz");
     }else if(i%3==0){
        list.add("Fizz");
      }else if(i%5==0){
        list.add("Buzz");
      }else {
        list.add(String.valueOf(i));
      }
    }
    return list;
  }


  public static int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
      return -1;
    }
    for(int i=0;i<=haystack.length()-needle.length();i++){
      int j;
      for(j=0;j<needle.length();j++){
        if(haystack.charAt(i+j)!=needle.charAt(j)){
          break;
        }
      }
      if(j==needle.length()){
        return i;
      }
    }
    return -1;
  }




  private static boolean reverseNumber(int num) {

      if(num<0 || num!=0 && num%10==0){ //handle 0 and -123
        return false;
      }

      int originalNumber = num;
      int reverseNumber =0;


      /*ƒ
          x = num/10  rev = num%10 rev*10+
       */

      while(num!=0){
        reverseNumber = num%10+reverseNumber*10; // 321
        num = num/10;// 1

      }


      return originalNumber==reverseNumber;

  }

  private static int myAtoi(String str) {
    str = str.trim();
    if(str.length() ==0 || str == null){
      return 0;
    }

    int startIndex = 0;
    boolean isNegative = false;
    if(str.charAt(0) == '+' || str.charAt(0) == '-'){
        startIndex++;
    }
    if(str.charAt(0)=='-'){
      isNegative = true;
    }

    double result = 0;
    //handle normal case
    for(int i=startIndex;i<str.length();i++){
      if(!Character.isDigit(str.charAt(i))){
        break;
      }

      int digitValue = (int)(str.charAt(i)-'0'); //'9'-'0'
      result = result * 10 +digitValue;
    }

    if(isNegative){
      result = -result;
    }

    if(result > Integer.MAX_VALUE){
      return Integer.MAX_VALUE;
    }

    if(result < Integer.MIN_VALUE){
      return Integer.MIN_VALUE;
    }

    return (int)result;

  }

  private static String longestCommonPrefix(String[] str) {

    if(str.length == 0 || str==null){
      return "";
    }
    String logestPrefix = str[0];
    for(int i=0;i<str.length;i++){
      int j=0;
      String currentPrefix = str[i];
      while(j<logestPrefix.length() && logestPrefix.charAt(j)==currentPrefix.charAt(j)){
        j++;
      }
      if(j==0){
        return "";
      }
      logestPrefix = logestPrefix.substring(0,j);
    }



    return logestPrefix;
  }

  private static int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }

    int[] charCounts = new int[26];

    for (int i = 0; i < s.length(); i++) {
      charCounts[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (charCounts[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }

    return -1;
  }

  private static int findDuplicate(int[] nums) {
    Set<Integer> hashSet = new HashSet<Integer>();
    for (int num : nums) {
      if(!(hashSet.add(num))){
        return num;
      }
    }
    return 0;
  }

  private static int majorityElement(int[] num) {
    if (num.length == 1) {
      return num[0];
    }

    Arrays.sort(num);
    return num[num.length / 2];
  }

  private static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<Integer>();

    for (int no : nums) {
      int index = Math.abs(no)-1;
      if (nums[index] > 0) {
        nums[index] = -nums[index];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i+1);
      }
    }

    return result;
  }

  private static int getmissingno(int[] a, int n) {
    int i, total;
    total  = (n+1)*(n+2)/2;
    for ( i = 0; i< n; i++)
      total -= a[i];
    return total;
  }


  private static void removeDuplicates(int[] nums) {
    Set<Integer> hashSet=new HashSet<Integer>();

    for (int num : nums) {
      hashSet.add(num);
    }
    int numbers[]=new int[hashSet.size()];
    int i=0;
    Iterator iter = hashSet.iterator();
    while (iter.hasNext()) {
      numbers[i] = (Integer) iter.next();
      i++;
    }
    for (int number : numbers) {
      System.out.println(number);
    }

  }

  private static void moveZeroes(int[] nums) {
    int count=0;
      for(int i=0;i<nums.length;i++){
        if(nums[i]!=0) {
          nums[count]=nums[i];
          count++;
        }
      }
      while(count<nums.length){
        nums[count]=0;
        count++;
      }
    printArray(nums);
  }

  public static void printArray(int[] nums){
    boolean first = true;
    for (int num : nums) {
      if(first){
        System.out.print("[");
        System.out.print(num);
        first=false;
      }
      else {
        System.out.print(",");
        System.out.print(num);
      }
    }
    System.out.print("]");
    System.out.println("");
  }


  private static int searchInsert(int[] nums, int target) {
    for(int i=0;i<nums.length;i++){
      if(nums[i]==target){
        return i;
      }else{
        if(nums[i]>target){
          return i--;
        }
      }
    }
    return nums.length;
  }

  private static int singlenumber(int[] nums) {

    Set<Integer> hashSet= new HashSet<Integer>();
    Map<Integer,Boolean> hashMap = new HashMap<Integer, Boolean>();
    for (int i : nums) {
      if(hashSet.add(i)){
        hashMap.put(i,true);
      }
      else{
        hashMap.put(i,false);
      }
    }

    Set<Map.Entry<Integer, Boolean>> entries = hashMap.entrySet();
    for (Map.Entry<Integer, Boolean> entry : entries) {
      if(entry.getValue()==true){
        return entry.getKey();
      }
    }
    return -101010; // If no duplicate value then return

  }
}
