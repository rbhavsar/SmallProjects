package DataStructure.SinglyLinkedList;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class SinglyLinkedList {
  private Node first;

  public SinglyLinkedList(){

  }

  public boolean isEmpty(){
    return (first == null);
  }

  //insert at the begining of the list
  public void insertFirst(int data){
    Node newNode = new Node();
    newNode.data = data;
    newNode.next=first;
    first = newNode;
  }

  public Node deleteFirst(){
    Node temp = first;
    first = first.next;
    return temp;
  }

  public void displayist(){
    System.out.println("List (First-->Last)");
    Node current = first;
    while(current!=null){
      current.displayNode();
      current = current.next;
    }
    System.out.println();
  }

  public void insertLast(int data){
    Node current = first;
    while(current.next !=null){
      current = current.next; //until current.next is null
    }
    Node newNode = new Node();
    newNode.data = data;
    current.next = newNode;
  }
}
