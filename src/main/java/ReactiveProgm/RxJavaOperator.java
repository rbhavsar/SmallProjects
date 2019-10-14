package ReactiveProgm;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author rbhavsar
 * Created on 1/21/19.
 */
public class RxJavaOperator {

  public static void main(String[] args) {
    Observable.just(1,2,3)
        .map(new Func1<Integer, Integer>() {
          @Override
          public Integer call(Integer i) {
            return i*i;
          }
        })
        .subscribe(new Action1<Integer>() {
          @Override
          public void call(Integer integer) {
            System.out.println(integer);
          }
        });


    Observable.just(1,2,3)
        .map(i -> i*i)
        .subscribe(System.out::println);
  }

}
