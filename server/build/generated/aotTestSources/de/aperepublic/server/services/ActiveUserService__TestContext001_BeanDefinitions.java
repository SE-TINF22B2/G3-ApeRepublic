package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ActiveUserService}.
 */
@Generated
public class ActiveUserService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'activeUserService'.
   */
  public static BeanDefinition getActiveUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ActiveUserService.class);
    beanDefinition.setInstanceSupplier(ActiveUserService::new);
    return beanDefinition;
  }
}
