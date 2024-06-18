package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StockService}.
 */
@Generated
public class StockService__BeanDefinitions {
  /**
   * Get the bean definition for 'stockService'.
   */
  public static BeanDefinition getStockServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StockService.class);
    InstanceSupplier<StockService> instanceSupplier = InstanceSupplier.using(StockService::new);
    instanceSupplier = instanceSupplier.andThen(StockService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
