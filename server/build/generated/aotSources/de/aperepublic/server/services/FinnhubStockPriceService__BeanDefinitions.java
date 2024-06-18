package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FinnhubStockPriceService}.
 */
@Generated
public class FinnhubStockPriceService__BeanDefinitions {
  /**
   * Get the bean definition for 'finnhubStockPriceService'.
   */
  public static BeanDefinition getFinnhubStockPriceServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FinnhubStockPriceService.class);
    beanDefinition.setInstanceSupplier(FinnhubStockPriceService::new);
    return beanDefinition;
  }
}
