package org.springframework.boot.actuate.autoconfigure.metrics.export.simple;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SimpleProperties}.
 */
@Generated
public class SimpleProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'simpleProperties'.
   */
  public static BeanDefinition getSimplePropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleProperties.class);
    beanDefinition.setInstanceSupplier(SimpleProperties::new);
    return beanDefinition;
  }
}
