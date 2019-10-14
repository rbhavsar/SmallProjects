package DataStructure;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class App {

  public static void main(String[] args) {
    Node nodeA = new Node();
    nodeA.data = 4;

    Node nodeB = new Node();
    nodeB.data = 3;

    Node nodeC = new Node();
    nodeC.data = 7;

    Node nodeD = new Node();
    nodeD.data = 8;


    nodeA.next = nodeB;
    nodeB.next = nodeC;
    nodeC.next = nodeD;

    System.out.println(listLength(nodeA)); //4
    System.out.println(listLength(nodeB)); //3

  }

  public static int listLength(Node node){
      int i = 0;
      Node currentNode = node;
      while (currentNode!=null){
        i++;
        currentNode = currentNode.next;
      }
      return i;
  }
}
