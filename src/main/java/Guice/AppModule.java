package Guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

/**
 * @author rbhavsar
 * Created on 10/11/19.
 */
public class AppModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(DrawShape.class).to(DrawSquare.class).in(Scopes.SINGLETON);
    bind(SquareRequest.class).to(SquareRequestSubClass.class);
    bind(SquareRequest.class).in(Singleton.class);
  }
}
