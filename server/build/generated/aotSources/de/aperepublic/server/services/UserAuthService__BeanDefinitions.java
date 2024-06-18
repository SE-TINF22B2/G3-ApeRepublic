package de.aperepublic.server.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserAuthService}.
 */
@Generated
public class UserAuthService__BeanDefinitions {
  /**
   * Get the bean definition for 'userAuthService'.
   */
  public static BeanDefinition getUserAuthServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserAuthService.class);
    InstanceSupplier<UserAuthService> instanceSupplier = InstanceSupplier.using(UserAuthService::new);
    instanceSupplier = instanceSupplier.andThen(UserAuthService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
