package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PriceHistoryTracker}.
 */
@Generated
public class PriceHistoryTracker__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'priceHistoryTracker'.
   */
  public static BeanDefinition getPriceHistoryTrackerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PriceHistoryTracker.class);
    beanDefinition.setInstanceSupplier(PriceHistoryTracker::new);
    return beanDefinition;
  }
}
