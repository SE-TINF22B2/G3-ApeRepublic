package de.aperepublic.server.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link StockController}.
 */
@Generated
public class StockController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static StockController apply(RegisteredBean registeredBean, StockController instance) {
    AutowiredFieldValueResolver.forRequiredField("stockService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
