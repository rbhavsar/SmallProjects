package Multithreading_Balazs_Udemy.Student_Library;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */
public class Book {

  private int id;
  private Lock lock;

  public Book(int id){
    this.id = id;
    this.lock = new ReentrantLock();
  }

  public void read(Student student) throws InterruptedException{
    //lock.tryLock(10, TimeUnit.MILLISECONDS);
    lock.lock();
    System.out.println(student+" starts reading "+this);
    Thread.sleep(2000);
    lock.unlock();
    System.out.println(student+" has finish reading "+this);
  }

  @Override
  public String toString(){
    return "Book #"+id;
  }
}
