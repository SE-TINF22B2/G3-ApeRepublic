package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link StockService}.
 */
@Generated
public class StockService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static StockService apply(RegisteredBean registeredBean, StockService instance) {
    AutowiredFieldValueResolver.forRequiredField("activeUserService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("positionRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("tradeRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("finnhubStockPriceService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
