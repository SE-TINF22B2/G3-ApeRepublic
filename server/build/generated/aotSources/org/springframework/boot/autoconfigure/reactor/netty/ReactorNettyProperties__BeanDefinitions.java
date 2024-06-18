package org.springframework.boot.autoconfigure.reactor.netty;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReactorNettyProperties}.
 */
@Generated
public class ReactorNettyProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'reactorNettyProperties'.
   */
  public static BeanDefinition getReactorNettyPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactorNettyProperties.class);
    beanDefinition.setInstanceSupplier(ReactorNettyProperties::new);
    return beanDefinition;
  }
}
