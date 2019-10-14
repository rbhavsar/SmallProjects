package DataStructure.BinarySearch;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class App {

  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(10,"Ten");
    tree.insert(20,"Twenty");
    tree.insert(15,"fifteen");

    System.out.println("min: "+tree.findMin().key);
    System.out.println("max: "+tree.findMax().key);


  }

}
