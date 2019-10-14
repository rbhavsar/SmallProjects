package Guice;

import com.google.inject.Inject;

/**
 * @author rbhavsar
 * Created on 10/11/19.
 */
public class SquareRequest {


  DrawShape d; //field injection

  @Inject
  public SquareRequest(DrawShape d){ // constructor injection
    this.d = d;
  }

  public void makeSquare(){
    d.shape();
  }

  public DrawShape getDraShape(){
    return d;
  }

//  @Inject
//  public void setDrawShape(DrawShape d){ // method injection
//    this.d=d;
//  }
}
