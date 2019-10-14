package DataStructure.SinglyLinkedList;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class App {

  public static void main(String[] args) {
    SinglyLinkedList myList = new SinglyLinkedList();
    myList.insertFirst(100);
    myList.insertFirst(50);
    myList.insertFirst(99);
    myList.insertFirst(88);
    myList.insertLast(45);

    myList.displayist();
  }
}
