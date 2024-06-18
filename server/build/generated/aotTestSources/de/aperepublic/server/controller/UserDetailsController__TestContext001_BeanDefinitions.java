package de.aperepublic.server.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserDetailsController}.
 */
@Generated
public class UserDetailsController__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'userDetailsController'.
   */
  public static BeanDefinition getUserDetailsControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserDetailsController.class);
    beanDefinition.setInstanceSupplier(UserDetailsController::new);
    return beanDefinition;
  }
}
