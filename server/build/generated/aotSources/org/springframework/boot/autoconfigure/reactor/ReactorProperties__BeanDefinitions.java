package org.springframework.boot.autoconfigure.reactor;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReactorProperties}.
 */
@Generated
public class ReactorProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'reactorProperties'.
   */
  public static BeanDefinition getReactorPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactorProperties.class);
    beanDefinition.setInstanceSupplier(ReactorProperties::new);
    return beanDefinition;
  }
}
