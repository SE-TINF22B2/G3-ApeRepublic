package de.aperepublic.server.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserAuthController}.
 */
@Generated
public class UserAuthController__BeanDefinitions {
  /**
   * Get the bean definition for 'userAuthController'.
   */
  public static BeanDefinition getUserAuthControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserAuthController.class);
    InstanceSupplier<UserAuthController> instanceSupplier = InstanceSupplier.using(UserAuthController::new);
    instanceSupplier = instanceSupplier.andThen(UserAuthController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}