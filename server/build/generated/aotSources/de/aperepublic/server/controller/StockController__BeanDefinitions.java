package de.aperepublic.server.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StockController}.
 */
@Generated
public class StockController__BeanDefinitions {
  /**
   * Get the bean definition for 'stockController'.
   */
  public static BeanDefinition getStockControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StockController.class);
    InstanceSupplier<StockController> instanceSupplier = InstanceSupplier.using(StockController::new);
    instanceSupplier = instanceSupplier.andThen(StockController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
