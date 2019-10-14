package ReactiveProgm;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author rbhavsar
 * Created on 1/21/19.
 */

/*
In RxJava, Observables are the source which emits items to the Observers.
For Observers to listen to the Observables, they need to subscribe first.

In order to stop listening to Observables,
we can call unsubscribe by calling the method dispose() on the Disposable instance

 */

public class RxJava1 {

  public static void main(String[] args) {
    Observable<String> avengers = Observable.create(s -> {
      s.onNext("iron man");
      s.onNext("Loki");
      s.onNext("hulk");
    });
    avengers.filter(avenger -> !avenger.equals("Loki"))
        .map(avenger -> avenger +" is an avenger")
        .subscribe(System.out::println);


    Observable.range(1,10)
        .map(i->i*5)
        .subscribeOn(Schedulers.computation())
        .subscribe(r -> {System.out.println(Thread.currentThread().getName());
          System.out.println(r);
        });


    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
