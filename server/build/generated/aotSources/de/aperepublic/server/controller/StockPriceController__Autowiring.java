package de.aperepublic.server.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link StockPriceController}.
 */
@Generated
public class StockPriceController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static StockPriceController apply(RegisteredBean registeredBean,
      StockPriceController instance) {
    instance.stockPriceService = AutowiredFieldValueResolver.forRequiredField("stockPriceService").resolve(registeredBean);
    return instance;
  }
}
