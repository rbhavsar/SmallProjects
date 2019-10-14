package DataStructure.Queue;

/**
 * @author rbhavsar
 * Created on 3/17/19.
 */
public class Queue {

  private int maxSize; // set number of slots
  private long[] queueArray; //slot to maintain the data
  private int front; //
  private int rear;//
  private int nItems;

  public Queue(int size){
    this.maxSize = size;
    this.queueArray = new long[size];
    front = 0; // index position of the first slot of the array
    rear = -1; //there is no item in the array yet
    nItems = 0; // we don't have elements in array yet
  }

  public void insert(long j){
//    if(rear == maxSize-1){ //Overrite , Circular queue
//      rear = -1;
//    }


    rear++;
    queueArray[rear] = j;
    nItems++;
  }

  public void view(){
    System.out.print("[ ");
    for(int i=0;i<queueArray.length;i++){
      System.out.print(queueArray[i]+" ");
    }
    System.out.print("]");
  }

  public long remove(){ // remove from first
    long temp = queueArray[front];
    front++;
    if(front==maxSize){
      front=0; // set to back to start
    }
    nItems--;
    return temp;

  }

  public long peekFront(){
    return queueArray[front];
  }

  public boolean isEmpty(){
    return (nItems==0);
  }

  public boolean isFull(){
    return (nItems==maxSize);
  }
}
