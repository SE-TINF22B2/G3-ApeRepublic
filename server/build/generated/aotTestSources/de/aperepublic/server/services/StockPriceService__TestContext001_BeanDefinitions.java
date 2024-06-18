package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StockPriceService}.
 */
@Generated
public class StockPriceService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'stockPriceService'.
   */
  public static BeanDefinition getStockPriceServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StockPriceService.class);
    InstanceSupplier<StockPriceService> instanceSupplier = InstanceSupplier.using(StockPriceService::new);
    instanceSupplier = instanceSupplier.andThen(StockPriceService__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
