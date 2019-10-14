package ReactiveProgm;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * @author rbhavsar
 * Created on 1/20/19.
 */

/*
For the Observer and Subscriber to listen to the data stream emitted by
the Observable they need to be subscribed using the subscribe() method as shown below.

myObservable.subscribe(mySubscriber);
myObservable.subscribe(myObserver);
 */

public class RxJavaUnitTestcase {

  public static void main(String[] args) {

    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    Observable<Integer> fromObservable = Observable.from(numbers);

    Subscriber<Integer> intSubscriber = new Subscriber<Integer>() {
      @Override
      public void onCompleted() {
        System.out.println("onCompleted");
      }

      @Override
      public void onError(Throwable e) {
        System.out.println("onError");
      }

      @Override
      public void onNext(Integer integer) {
        System.out.println("onNext: "+ integer);
      }
    };

    fromObservable.subscribe(intSubscriber);

  }
}
