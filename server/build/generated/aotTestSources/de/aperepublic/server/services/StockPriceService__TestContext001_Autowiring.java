package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link StockPriceService}.
 */
@Generated
public class StockPriceService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static StockPriceService apply(RegisteredBean registeredBean, StockPriceService instance) {
    AutowiredFieldValueResolver.forRequiredField("activeUserService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("priceHistoryTracker").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
