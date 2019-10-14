package DataStructure.Sorting;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] myArray = selectionSort(new int[]{10,1,3,20,5});
    for (int i : myArray) {
      System.out.println(i);
    }
  }

  private static int[] selectionSort(int[] nums) {
    //{1,3,5,20,10}
    for(int i=0;i<nums.length;i++){
      int min=i; //2
      for(int j=i+1;j<nums.length;j++){
        if(nums[j]<nums[min]){
          min=j;//4
        }
      }
      int temp=nums[i];//10
      nums[i]=nums[min];//5
      nums[min]=temp;//10
      //{1,3,5,20,10}
    }
    return nums;
  }

}
